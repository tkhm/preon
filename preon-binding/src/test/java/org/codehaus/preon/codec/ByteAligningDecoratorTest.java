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
import org.codehaus.preon.annotation.ByteAlign;
import org.codehaus.preon.buffer.BitBuffer;

import java.lang.reflect.AnnotatedElement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ByteAligningDecoratorTest extends junit.framework.TestCase {

    private Codec codec;
    private AnnotatedElement metadata;
    private BitBuffer buffer;
    private Resolver resolver;
    private Builder builder;
    private ResolverContext context;

    public void setUp() {
        codec = mock(Codec.class);
        metadata = mock(AnnotatedElement.class);
        buffer = mock(BitBuffer.class);
        resolver = mock(Resolver.class);
        context = mock(ResolverContext.class);
    }

    public void testAligningType() throws DecodingException {
        ByteAligningDecorator decorator = new ByteAligningDecorator();
        when(codec.decode(buffer, resolver, builder)).thenReturn(new Object());
        when(buffer.getBitPos()).thenReturn(12L);
        buffer.setBitPos(16L);

        Codec decorated = decorator.decorate(codec, metadata, Test1.class, context);
        assertNotSame(decorated, codec);
        decorated.decode(buffer, resolver, builder);
    }

    public void testAligningField() throws DecodingException {
        ByteAligningDecorator decorator = new ByteAligningDecorator();
        when(codec.decode(buffer, resolver, builder)).thenReturn(new Object());
        when(buffer.getBitPos()).thenReturn(12L);
        when(metadata.isAnnotationPresent(ByteAlign.class)).thenReturn(true);
        buffer.setBitPos(16L);

        Codec decorated = decorator.decorate(codec, metadata, Test2.class, context);
        assertNotSame(decorated, codec);
        decorated.decode(buffer, resolver, builder);
    }


    @ByteAlign
    private class Test1 {

    }

    private class Test2 {

    }

}
