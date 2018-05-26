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
import org.codehaus.preon.CodecFactory;
import org.codehaus.preon.ResolverContext;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.AnnotatedElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CompoundCodecFactoryTest {

    private CodecFactory delegate1;

    private CodecFactory delegate2;

    private Codec<Integer> codec;

    private AnnotatedElement metadata;

    private ResolverContext context;

    private CompoundCodecFactory factory;

    @Before
    public void setUp() {
        delegate1 = mock(CodecFactory.class);
        delegate2 = mock(CodecFactory.class);
        codec = mock(Codec.class);
        context = mock(ResolverContext.class);
        factory = new CompoundCodecFactory();
        factory.add(delegate1);
        factory.add(delegate2);
    }

    @Test
    public void testNoMatch() {
        when(delegate1.create(metadata, Integer.class, context)).thenReturn(null);
        when(delegate2.create(metadata, Integer.class, context)).thenReturn(null);
        assertNull(factory.create(metadata, Integer.class, context));
    }

    @Test
    public void testSecondMatch() {
        when(delegate1.create(metadata, Integer.class, context)).thenReturn(null);
        when(delegate2.create(metadata, Integer.class, context)).thenReturn(codec);
        assertEquals(codec, factory.create(metadata, Integer.class, context));
    }

}
