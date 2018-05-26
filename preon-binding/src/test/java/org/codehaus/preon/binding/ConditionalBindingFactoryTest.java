/**
 * Copyright (c) 2009-2016 Wilfred Springer
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.codehaus.preon.binding;

import org.codehaus.preon.*;
import org.codehaus.preon.annotation.If;
import org.codehaus.preon.buffer.BitBuffer;
import org.codehaus.preon.el.BindingException;
import org.codehaus.preon.el.Expression;
import org.codehaus.preon.el.Reference;
import org.codehaus.preon.el.ReferenceContext;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ConditionalBindingFactoryTest {

    private BindingFactory decorated;

    private ConditionalBindingFactory factory;

    private BitBuffer buffer;

    private Resolver resolver;

    private Field field;

    private Codec<?> codec;

    private AnnotatedElement metadata;

    private If condition;

    private Binding binding;

    private Builder builder;

    private ResolverContext context;

    private Expression<Integer, Resolver> sizeExpr;

    @Before
    public void setUp() {
        binding = mock(Binding.class);
        decorated = mock(BindingFactory.class);
        buffer = mock(BitBuffer.class);
        resolver = mock(Resolver.class);
        field = getTestField();
        codec = mock(Codec.class);
        condition = mock(If.class);
        metadata = mock(AnnotatedElement.class);
        factory = new ConditionalBindingFactory(decorated);
        builder = mock(Builder.class);
        context = mock(ResolverContext.class);
        sizeExpr = mock(Expression.class);
    }

    private static Field getTestField() {
        try {
            return Test.class.getDeclaredField("value");
        } catch (SecurityException e) {
        } catch (NoSuchFieldException e) {
        }
        return null;
    }

    @Test
    public void testConditionals() throws CodecException {
        testConditionalLoad("a > b", 3, 2, true, false);
        testConditionalLoad("a > b", 1, 1, false, false);
        testConditionalLoad("a > b", 2, 3, false, false);
    }

    private void testConditionalLoad(String expr, int a, int b, boolean bindingAction,
                                    boolean compilationFailure) throws DecodingException {
        TestSubject test = new TestSubject();
        test.value = "whatever";
        when(metadata.getAnnotation(If.class)).thenReturn(condition);
        when(condition.value()).thenReturn(expr);
        when(decorated.create(metadata, field, codec, context)).thenReturn(binding);
        if (!compilationFailure) {
            when(context.selectAttribute("a")).thenReturn(new SimpleIntegerReference("a")); // Reference not used
            when(context.selectAttribute("b")).thenReturn(new SimpleIntegerReference("b")); // Reference not used
            when(resolver.get("a")).thenReturn(Integer.valueOf(a));
            when(resolver.get("b")).thenReturn(Integer.valueOf(b));
        }
        if (bindingAction) {
            when(binding.getSize()).thenReturn(sizeExpr);
            when(sizeExpr.eval(resolver)).thenReturn(6);
            binding.load(test, buffer, resolver, builder);
        } else {
            when(binding.getSize()).thenReturn(sizeExpr);
        }

        Binding conditionalBinding = factory.create(metadata, field, codec, context);
        if (bindingAction) {
            assertEquals(Integer.valueOf(6), conditionalBinding.getSize().eval(resolver));
        } else {
            assertEquals(Integer.valueOf(0), conditionalBinding.getSize().eval(resolver));
        }
        conditionalBinding.load(test, buffer, resolver, builder);
    }

    public static class TestSubject {

        public String value;

    }

    private static class SimpleIntegerReference implements Reference<Resolver> {

        private String name;

        public SimpleIntegerReference(String name) {
            this.name = name;
        }

        public ReferenceContext<Resolver> getReferenceContext() {
            return null;
        }

        public boolean isAssignableTo(Class<?> type) {
            // TODO Auto-generated method stub
            return false;
        }

        public Object resolve(Resolver context) {
            return context.get(name);
        }

        public Reference<Resolver> selectAttribute(String name) {
            throw new BindingException("Attribute selection not allowed.");
        }

        public Reference<Resolver> selectItem(String index) {
            throw new BindingException("Item selection not allowed.");
        }

        public Reference<Resolver> selectItem(Expression<Integer, Resolver> index) {
            throw new BindingException("Item selection not allowed.");
        }

        public Class<?> getType() {
            return Integer.class;
        }

        public Reference<Resolver> narrow(Class<?> type) {
            if (type.isAssignableFrom(Integer.class)) {
                return this;
            } else {
                return null;
            }
        }

        public boolean isBasedOn(ReferenceContext<Resolver> resolverReferenceContext) {
            return false;
        }

        public Reference<Resolver> rescope(ReferenceContext<Resolver> resolverReferenceContext) {
            return this;
        }

    }

}
