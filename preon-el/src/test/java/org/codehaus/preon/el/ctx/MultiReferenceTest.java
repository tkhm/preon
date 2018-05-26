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
package org.codehaus.preon.el.ctx;

import org.codehaus.preon.el.BindingException;
import org.codehaus.preon.el.Reference;
import org.codehaus.preon.el.ReferenceContext;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A collection of tests for the {@link MultiReference}.
 * 
 * @author Wilfred Springer (wis)
 * 
 */
public class MultiReferenceTest {

    private Reference reference1;

    private Reference reference2;

    private Reference reference3;

    private ReferenceContext context;

    @Before
    public void setUp() {
        this.reference1 = mock(Reference.class);
        this.reference2 = mock(Reference.class);
        this.reference3 = mock(Reference.class);
        this.context = mock(ReferenceContext.class);
    }

    @Test
    public void testResolution() {
        Object runtimeContext = new Object();
        Object result = new Object();
        when(reference1.getReferenceContext()).thenReturn(context);
        when(reference2.getReferenceContext()).thenReturn(context);
        when(reference1.resolve(runtimeContext)).thenReturn(result);
        when(reference1.getType()).thenReturn(String.class);
        when(reference2.getType()).thenReturn(Date.class);

        MultiReference multi = new MultiReference(reference1, reference2);
        assertEquals(result, multi.resolve(runtimeContext));
    }

    @Test
    public void testResolution2ndAttempt() {
        Object runtimeContext = new Object();
        Object result = new Object();
        when(reference1.getReferenceContext()).thenReturn(context);
        when(reference2.getReferenceContext()).thenReturn(context);
        when(reference1.resolve(runtimeContext)).thenThrow(new BindingException("Not found."));
        when(reference2.resolve(runtimeContext)).thenReturn(result);
        when(reference1.getType()).thenReturn(String.class);
        when(reference2.getType()).thenReturn(String.class);

        MultiReference multi = new MultiReference(reference1, reference2);
        assertEquals(result, multi.resolve(runtimeContext));
    }

    @Test(expected=BindingException.class)
    public void testFailedResolution() {
        Object runtimeContext = new Object();
        Object result = new Object();
        when(reference1.getReferenceContext()).thenReturn(context);
        when(reference2.getReferenceContext()).thenReturn(context);
        when(reference1.getType()).thenReturn(String.class);
        when(reference2.getType()).thenReturn(String.class);
        when(reference1.resolve(runtimeContext)).thenThrow(new BindingException("Not found."));
        when(reference2.resolve(runtimeContext)).thenThrow(new BindingException("Not found."));
        MultiReference multi = new MultiReference(reference1, reference2);

        multi.resolve(runtimeContext);
    }

    @Test
    public void testSelectIndex() {
        String index = "pi";
        Reference selected1 = mock(Reference.class);
        Reference selected2 = mock(Reference.class);
        when(reference1.getReferenceContext()).thenReturn(context);
        when(reference2.getReferenceContext()).thenReturn(context);
        when(reference1.getType()).thenReturn(String.class);
        when(reference2.getType()).thenReturn(String.class);
        when(selected1.getType()).thenReturn(String.class);
        when(selected2.getType()).thenReturn(String.class);
        when(reference1.selectItem(index)).thenReturn(selected1);
        when(reference2.selectItem(index)).thenReturn(selected2);
        when(selected1.getReferenceContext()).thenReturn(context);
        when(selected2.getReferenceContext()).thenReturn(context);

        MultiReference multi = new MultiReference(reference1, reference2);
        assertNotNull(multi.selectItem(index));

    }

    @Test
    public void testSelectProperty() {
        String propertyName = "pi";
        Reference selected1 = mock(Reference.class);
        Reference selected2 = mock(Reference.class);
        when(reference1.getType()).thenReturn(String.class);
        when(reference2.getType()).thenReturn(String.class);
        when(selected1.getType()).thenReturn(String.class);
        when(selected2.getType()).thenReturn(String.class);
        when(reference1.getReferenceContext()).thenReturn(context);
        when(reference2.getReferenceContext()).thenReturn(context);
        when(reference1.selectAttribute(propertyName)).thenReturn(selected1);
        when(reference2.selectAttribute(propertyName)).thenReturn(selected2);
        when(selected1.getReferenceContext()).thenReturn(context);
        when(selected2.getReferenceContext()).thenReturn(context);

        MultiReference multi = new MultiReference(reference1, reference2);
        assertNotNull(multi.selectAttribute(propertyName));
    }
}
