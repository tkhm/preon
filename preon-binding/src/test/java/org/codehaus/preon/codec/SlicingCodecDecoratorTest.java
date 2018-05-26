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
import org.codehaus.preon.ResolverContext;
import org.codehaus.preon.annotation.LengthPrefix;
import org.codehaus.preon.annotation.Slice;
import org.codehaus.preon.buffer.BitBuffer;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SlicingCodecDecoratorTest {

    private BitBuffer buffer;
    private BitBuffer slice;
    private AnnotatedElement metadata;
    private LengthPrefix prefix;
    private Codec decorated;
    private ResolverContext context;
    private Resolver resolver;

    @Before
    public void setUp() {
        buffer = mock(BitBuffer.class);
        slice = mock(BitBuffer.class);
        metadata = mock(AnnotatedElement.class);
        prefix = mock(LengthPrefix.class);
        decorated = mock(Codec.class);
        resolver = mock(Resolver.class);
        context = mock(ResolverContext.class);
    }

    @Test
    public void testSlicingWithSliceAnnotation() throws DecodingException {
        Test2 value = new Test2();

        // Stuff happening when we are decoding
        when(buffer.slice(8L)).thenReturn(slice);
        when(decorated.decode(slice, resolver, null)).thenReturn(value);

        SlicingCodecDecorator factory = new SlicingCodecDecorator();
        Codec<Test2> codec = factory.decorate(decorated, metadata, Test2.class, context);
        codec.decode(buffer, resolver, null);
    }

    @Test
    public void testNoAnnotationsNoNothing() throws DecodingException {
        when(metadata.isAnnotationPresent(Slice.class)).thenReturn(false);

        SlicingCodecDecorator factory = new SlicingCodecDecorator();
        Codec<Test3> codec = factory.decorate(decorated, metadata, Test3.class, context);
        assertEquals(codec, decorated);
    }

    @Slice(size = "8")
    public static class Test2 {

    }

    public static class Test3 {

    }

}
