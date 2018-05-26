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

import org.codehaus.preon.*;
import org.codehaus.preon.annotation.Bound;
import org.codehaus.preon.annotation.BoundObject;
import org.codehaus.preon.annotation.Choices;
import org.codehaus.preon.annotation.TypePrefix;
import org.codehaus.preon.buffer.BitBuffer;
import org.codehaus.preon.buffer.ByteOrder;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ObjectCodecFactoryTest {

    private AnnotatedElement metadata;

    private CodecFactory delegate;

    private BitBuffer buffer;

    private Resolver resolver;

    private Builder builder;

    private BoundObject settings;

    private Choices choices;

    @Before
    public void setUp() {
        metadata = mock(AnnotatedElement.class);
        delegate = mock(CodecFactory.class);
        buffer = mock(BitBuffer.class);
        resolver = mock(Resolver.class);
        settings = mock(BoundObject.class);
        builder = mock(Builder.class);
        choices = mock(Choices.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testBoundObjectNoMembersTwoTypesNoPrefix() throws DecodingException {
        Codec codec1 = mock(Codec.class);
        Codec codec2 = mock(Codec.class);
        when(metadata.isAnnotationPresent(Bound.class)).thenReturn(false);
        when(metadata.isAnnotationPresent(BoundObject.class)).thenReturn(true);
        when(metadata.getAnnotation(BoundObject.class)).thenReturn(settings);
        when(settings.selectFrom()).thenReturn(choices);
        when(choices.alternatives()).thenReturn(new Choices.Choice[0]);
        when(choices.defaultType()).thenReturn((Class) Void.class);
        when(settings.type()).thenReturn((Class) Void.class);
        when(settings.types()).thenReturn(new Class[]{TestObject1.class, TestObject2.class});
        when(delegate.create((AnnotatedElement) isNull(), isA(Class.class), (ResolverContext) isNull())).thenReturn(codec1);
        when(codec1.getTypes()).thenReturn(new Class[]{TestObject1.class});
        when(codec2.getTypes()).thenReturn(new Class[]{TestObject2.class});
        when(
                delegate.create((AnnotatedElement) isNull(), isA(Class.class),
                        (ResolverContext) isNull())).thenReturn(codec2);
        ObjectCodecFactory factory = new ObjectCodecFactory(delegate);
        try {
            Codec<TestObject1> created = factory.create(metadata, TestObject1.class, null);
            fail("Expecting failure due to missing prefixes.");
        } catch (CodecConstructionException cce) {
            // What we expect.
        }
    }

    @Test
    public void testBoundObjectNoMembersTwoTypesWithPrefix() throws DecodingException {
        Codec codecTest3 = mock(Codec.class);
        Codec codecTest4 = mock(Codec.class);
        when(metadata.isAnnotationPresent(Bound.class)).thenReturn(false);
        when(metadata.isAnnotationPresent(BoundObject.class)).thenReturn(true);
        when(settings.selectFrom()).thenReturn(choices);
        when(choices.alternatives()).thenReturn(new Choices.Choice[0]);
        when(choices.defaultType()).thenReturn((Class) Void.class);
        when(metadata.getAnnotation(BoundObject.class)).thenReturn(settings);
        when(settings.type()).thenReturn((Class) Void.class);
        when(settings.types()).thenReturn(new Class[]{TestObject3.class, TestObject4.class});
        when(delegate.create(null, TestObject3.class, null)).thenReturn(codecTest3);
        when(codecTest3.getTypes()).thenReturn(new Class<?>[]{TestObject3.class});
        when(codecTest4.getTypes()).thenReturn(new Class<?>[]{TestObject4.class});
        when(delegate.create(null, TestObject4.class, null)).thenReturn(codecTest4);
        // when(codecTest3.getSize(resolver)).thenReturn(6);
        // when(codecTest4.getSize(resolver)).thenReturn(6);
        when(buffer.readAsLong(8, ByteOrder.LittleEndian)).thenReturn(0L);
        when(codecTest3.decode(buffer, resolver, builder)).thenReturn(new TestObject3());

        ObjectCodecFactory factory = new ObjectCodecFactory(delegate);
        Codec<TestObject1> codec = factory.create(metadata, TestObject1.class, null);
        assertNotNull(codec);
        TestObject1 result = codec.decode(buffer, resolver, builder);
        assertNotNull(result);
        assertTrue(!(result instanceof TestObject4));
        assertTrue(result instanceof TestObject3);
    }

    public static class TestObject1 {

    }

    public static class TestObject2 {

    }

    @TypePrefix(size = 8, value = "0")
    public static class TestObject3 extends TestObject1 {

    }

    @TypePrefix(size = 8, value = "1")
    public static class TestObject4 extends TestObject1 {

    }

}
