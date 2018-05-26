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

import junit.framework.TestCase;
import org.codehaus.preon.Resolver;
import org.codehaus.preon.ResolverContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OuterReferenceTest {

    private ResolverContext outerContext;
    private ResolverContext originalContext;
    private Reference sampleReference;
    private Resolver outerResolver;
    private Resolver originalResolver;

    @Before
    public void setUp() {
        outerContext = mock(ResolverContext.class);
        originalContext = mock(ResolverContext.class);
        sampleReference = mock(Reference.class);
        outerResolver = mock(Resolver.class);
        originalResolver = mock(Resolver.class);
    }

    @Test
    public void testCreateReference() {
        when(outerContext.selectAttribute("foobar")).thenReturn(sampleReference);
        when(originalResolver.get(OuterReference.DEFAULT_OUTER_NAME)).thenReturn(outerResolver);
        when(sampleReference.resolve(any(Resolver.class))).thenReturn("Wilfred");
        when(originalResolver.getOriginalResolver()).thenReturn(originalResolver);

        OuterReference reference = new OuterReference(outerContext,
                originalContext);
        Reference<Resolver> result = reference.selectAttribute("foobar");
        assertNotSame(sampleReference, result);
        assertEquals(originalContext, result.getReferenceContext());
        result.resolve(originalResolver);
    }

    @Test(expected = BindingException.class)
    public void testResolveOuterResolverNull() {
        when(outerContext.selectAttribute("foobar")).thenReturn(sampleReference);
        when(originalResolver.get(OuterReference.DEFAULT_OUTER_NAME)).thenReturn(null);

        OuterReference reference = new OuterReference(outerContext, originalContext);
        Reference<Resolver> result = reference.selectAttribute("foobar");

        result.resolve(originalResolver);
    }
}
