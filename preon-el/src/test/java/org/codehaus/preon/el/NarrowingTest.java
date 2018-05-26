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
package org.codehaus.preon.el;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NarrowingTest {

    private ReferenceContext<Object> context = mock(ReferenceContext.class);
    private Reference<Object> reference1 = mock(Reference.class);
    private Reference<Object> reference2 = mock(Reference.class);

    @Test
    public void testAssignable() {
        assertTrue(Number.class.isAssignableFrom(Long.class));
        assertFalse(Long.class.isAssignableFrom(Number.class));
    }

    @Test(expected = BindingException.class)
    public void testNoNarrowingPossible() {
        when(context.selectAttribute("a")).thenReturn(reference1);
        Mockito.<Class<?>>when(reference1.getType()).thenReturn(Integer.class);
        Expressions.createBoolean(context, "a=='123'");
    }

    @Test
    public void testNoNarrowingNeeded() {
        when(context.selectAttribute("a")).thenReturn(reference1);
        Mockito.<Class<?>>when(reference1.getType()).thenReturn(String.class);

        Expressions.createBoolean(context, "a=='123'");
    }

    @Test
    public void testNarrowingPossibleAndNeeded() {
        when(context.selectAttribute("a")).thenReturn(reference1);
        Mockito.<Class<?>>when(reference1.getType()).thenReturn(Object.class);
        when(reference1.narrow(String.class)).thenReturn(reference2);
        Mockito.<Class<?>>when(reference2.getType()).thenReturn(String.class);

        Expressions.createBoolean(context, "a=='123'");
    }
}
