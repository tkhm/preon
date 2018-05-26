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
package org.codehaus.preon.codec;

import org.codehaus.preon.Codec;
import org.codehaus.preon.DecodingException;
import org.codehaus.preon.Resolver;
import org.codehaus.preon.annotation.LazyLoading;
import org.codehaus.preon.buffer.BitBuffer;
import org.codehaus.preon.el.Expression;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LazyLoadingCodecDecoratorTest {

    private Codec wrapped;

    private BitBuffer buffer;

    private LazyLoadingCodecDecorator factory;

    private AnnotatedElement metadata;

    private LazyLoading annotation;

    private Resolver resolver;

    private Expression<Integer, Resolver> sizeExpr;

    @Before
    public void setUp() {
        wrapped = mock(Codec.class);
        buffer = mock(BitBuffer.class);
        factory = new LazyLoadingCodecDecorator();
        metadata = mock(AnnotatedElement.class);
        annotation = mock(LazyLoading.class);
        resolver = mock(Resolver.class);
        sizeExpr = mock(Expression.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testHappyPath() throws DecodingException {

        TestSubject test = new TestSubject();

        // Stuff expected when Codec is getting constructed
        when(metadata.isAnnotationPresent(LazyLoading.class)).thenReturn(true);
        when(wrapped.getSize()).thenReturn(sizeExpr);
        when(sizeExpr.eval(resolver)).thenReturn(32);

        // Stuff expected when Test instance is constructed using Codec
        when(buffer.getBitPos()).thenReturn(64L);
        buffer.setBitPos(64L + 32);

        // Stuff expected after when Test instance is accessed
        buffer.setBitPos(64L);
        when(wrapped.decode(buffer, resolver, null)).thenReturn(test);

        Codec<TestSubject> codec = factory.decorate(wrapped, metadata, TestSubject.class, null);
        assertNotNull(codec);
        TestSubject result = codec.decode(buffer, resolver, null);
        assertNotNull(result);
        assertEquals("bar", result.getFoo());
        // Second time should not cause reload.
        assertEquals("bar", result.getFoo());
    }

    public static class TestSubject {

        public String getFoo() {
            return "bar";
        }

    }

}
