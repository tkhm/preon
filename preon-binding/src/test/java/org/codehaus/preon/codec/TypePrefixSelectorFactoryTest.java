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
import org.codehaus.preon.annotation.TypePrefix;
import org.codehaus.preon.buffer.BitBuffer;
import org.codehaus.preon.buffer.ByteOrder;
import org.codehaus.preon.el.Reference;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TypePrefixSelectorFactoryTest {

    private ResolverContext context;

    private Codec<?> codec1;

    private Codec<?> codec2;

    private Resolver resolver;

    private BitBuffer bitBuffer;

    private Reference<Resolver> reference;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        context = mock(ResolverContext.class);
        codec1 = mock(Codec.class);
        codec2 = mock(Codec.class);
        resolver = mock(Resolver.class);
        bitBuffer = mock(BitBuffer.class);
        reference = mock(Reference.class);
    }

    @Test
    public void testSimplePrefixes() throws DecodingException {
        when(codec1.getTypes()).thenReturn(new Class<?>[]{Test1.class});
        when(codec2.getTypes()).thenReturn(new Class<?>[]{Test2.class});
        when(bitBuffer.readAsLong(8, ByteOrder.LittleEndian)).thenReturn(1L);

        CodecSelectorFactory factory = new TypePrefixSelectorFactory();
        List<Codec<?>> codecs = new ArrayList<Codec<?>>();
        codecs.add(codec1);
        codecs.add(codec2);
        CodecSelector selector = factory.create(context, codecs);
        selector.select(bitBuffer, resolver);
    }

    @Test
    public void testPrefixesWithReferences() throws DecodingException {
        when(codec1.getTypes()).thenReturn(new Class<?>[]{Test3.class});
        when(codec2.getTypes()).thenReturn(new Class<?>[]{Test4.class});
        when(context.selectAttribute("p")).thenReturn(reference);
        when(bitBuffer.readAsLong(8, ByteOrder.LittleEndian)).thenReturn(1L);
        when(reference.resolve(resolver)).thenReturn(-2);
        when(reference.getType()).thenReturn((Class) Integer.class);

        CodecSelectorFactory factory = new TypePrefixSelectorFactory();
        List<Codec<?>> codecs = new ArrayList<Codec<?>>();
        codecs.add(codec1);
        codecs.add(codec2);
        CodecSelector selector = factory.create(context, codecs);
        selector.select(bitBuffer, resolver);
    }

    @TypePrefix(value = "1", size = 8)
    private static class Test1 {

    }

    @TypePrefix(value = "2", size = 8)
    private static class Test2 {

    }

    @TypePrefix(value = "p + 3", size = 8)
    private static class Test3 {

    }

    @TypePrefix(value = "2", size = 8)
    private static class Test4 {

    }

}
