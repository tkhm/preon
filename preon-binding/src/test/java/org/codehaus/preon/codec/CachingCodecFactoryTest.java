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
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CachingCodecFactoryTest {

    private CodecFactory delegate;

    private Codec<String> codec1;

    private Codec<Date> codec2;

    private AnnotatedElement metadata;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        delegate = mock(CodecFactory.class);
        codec1 = mock(Codec.class);
        codec2 = mock(Codec.class);
        metadata = mock(AnnotatedElement.class);
    }

    @Test
    /** Tests if the {@link CachingCodecFactory} correctly returns the same codec for identical requests. */
    public void testCachingStrategy() {
        when(delegate.create(metadata, String.class, null)).thenReturn(codec1);
        when(delegate.create(metadata, Date.class, null)).thenReturn(codec2);
        when(metadata.getAnnotations()).thenReturn(new Annotation[0]);

        CachingCodecFactory factory = new CachingCodecFactory(delegate);
        assertEquals(codec1, factory.create(metadata, String.class, null));
        assertEquals(codec2, factory.create(metadata, Date.class, null));
        Codec<String> cacheRef = factory.create(metadata, String.class, null);
        assertNotNull(cacheRef);
    }

}
