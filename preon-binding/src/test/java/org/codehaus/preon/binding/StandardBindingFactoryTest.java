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

import org.codehaus.preon.Codec;
import org.codehaus.preon.DecodingException;
import org.codehaus.preon.annotation.BoundNumber;
import org.codehaus.preon.buffer.BitBufferUnderflowException;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StandardBindingFactoryTest {

    private StandardBindingFactory factory;

    private Codec<Spam> codec;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        codec = mock(Codec.class);
        factory = new StandardBindingFactory();
    }

    @Test
    public void shouldHaveAccessToNonPublicFields() throws Exception {
        Field field = Spam.class.getDeclaredField("eggs");
        Binding binding = factory.create(null, field, codec, null);
        binding.save(new Spam(), null, null);
    }

    @Test
    public void testBitBufferUnderflowWithDetails() throws Exception {
        doTestDecodingExceptionHandling(new BitBufferUnderflowException(17, 3));
    }

    @Test
    public void testAnyExceptionWithDetails() throws Exception {
        doTestDecodingExceptionHandling(new IllegalArgumentException("Junit illegal argument"));
    }

    private void doTestDecodingExceptionHandling(Throwable t) throws Exception {
        expectedException.expect(DecodingException.class);
        expectedException.expectMessage("Error decoding field [eggs] in type [Spam]");
        expectedException.expectCause(new CauseMatcher(t.getClass()));
        Field field = Spam.class.getDeclaredField("eggs");
        when(codec.decode(any(), any(), any())).thenThrow(t);
        factory.create(null, field, codec, null).load(new Spam(), null, null, null);
    }

    public static class Spam {
        @BoundNumber(size = "16")
        private int eggs;
    }

    private static class CauseMatcher extends TypeSafeMatcher<Throwable> {

        private Class<? extends Throwable> expected;

        public CauseMatcher(Class<? extends Throwable> expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(Throwable throwable) {
            return throwable.getClass().isAssignableFrom(expected);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Expects ").appendText(expected.getClass().getName());
        }
    }
}
