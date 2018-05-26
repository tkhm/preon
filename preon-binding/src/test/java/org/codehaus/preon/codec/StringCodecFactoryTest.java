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
import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.annotation.BoundString.Encoding;
import org.codehaus.preon.annotation.BoundString.NullConverter;
import org.codehaus.preon.buffer.BitBuffer;
import org.codehaus.preon.buffer.DefaultBitBuffer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.AnnotatedElement;
import java.nio.ByteBuffer;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StringCodecFactoryTest {

    private BoundString settings;

    private AnnotatedElement metadata;

    private ResolverContext context;

    private Builder builder;

    private Resolver resolver;

    @Before
    public void setUp() {
        settings = mock(BoundString.class);
        metadata = mock(AnnotatedElement.class);
        context = mock(ResolverContext.class);
        builder = mock(Builder.class);
        resolver = mock(Resolver.class);
    }

    @Test
    public void testDecoding() throws Exception {
        when(metadata.getAnnotation(BoundString.class)).thenReturn(settings);
        when(settings.encoding()).thenReturn(Encoding.ASCII);
        when(settings.size()).thenReturn("2");
        Mockito.<Class<?>>when(settings.converter()).thenReturn(NullConverter.class);
        when(settings.match()).thenReturn("");

        Codec<String> codec = new StringCodecFactory().create(metadata, String.class, context);

        String result = codec.decode(wrap("bm"), resolver, builder);
        assertNotNull(result);
        assertEquals("bm", result);
    }

    @Test(expected = IllegalStateException.class)
    public void testMatching() throws Throwable {
        when(metadata.getAnnotation(BoundString.class)).thenReturn(settings);
        when(settings.encoding()).thenReturn(Encoding.ASCII);
        when(settings.size()).thenReturn("2");
        Mockito.<Class<?>>when(settings.converter()).thenReturn(NullConverter.class);
        when(settings.match()).thenReturn("fo");

        Codec<String> codec = new StringCodecFactory().create(metadata, String.class, context);

        try {
            String result = codec.decode(wrap("bm"), resolver, builder);
            fail("Matching should have failed.");
        } catch (DecodingException de) {
            throw de.getCause();
        }
    }

    @Test
    public void testNullTerminatedString() throws Exception {
        when(metadata.getAnnotation(BoundString.class)).thenReturn(settings);
        when(settings.encoding()).thenReturn(Encoding.ASCII);
        when(settings.size()).thenReturn("");
        Mockito.<Class<?>>when(settings.converter()).thenReturn(NullConverter.class);
		when(settings.match()).thenReturn("");

        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        byteBuffer.put("bm".getBytes("US-ASCII"));
        byteBuffer.put((byte) 0);
        byteBuffer.flip();

        Codec<String> codec = new StringCodecFactory().create(metadata, String.class, context);
        assertEquals("bm", codec.decode(new DefaultBitBuffer(byteBuffer), resolver, builder));
    }

    private BitBuffer wrap(String string) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(string.length());
        byteBuffer.put(string.getBytes("US-ASCII"));
        //string.chars().forEach(i -> byteBuffer.put((byte) i));
        byteBuffer.flip();
        return new DefaultBitBuffer(byteBuffer);
    }
}
