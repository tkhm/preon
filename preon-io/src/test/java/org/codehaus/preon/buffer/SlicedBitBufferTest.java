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
package org.codehaus.preon.buffer;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;


public class SlicedBitBufferTest {

    private BitBuffer delegate;

    @Before
    public void setUp() {
        delegate = mock(BitBuffer.class);
    }

    @Test
    public void testReading() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1);
        byteBuffer.put((byte) 154); // 10011010
        byteBuffer.rewind(); // reset to zero

        BitBuffer slice = new SlicedBitBuffer(new DefaultBitBuffer(byteBuffer), 5);

        assertTrue(slice.readAsBoolean());
        assertFalse(slice.readAsBoolean());
        assertFalse(slice.readAsBoolean());
        assertTrue(slice.readAsBoolean());
        assertTrue(slice.readAsBoolean());

        try {
            assertTrue(slice.readAsBoolean());
            fail("Expected ButBufferUnderflow");
        } catch (BitBufferUnderflowException e) {
            // ok
        }
    }

}
