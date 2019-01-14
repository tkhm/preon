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
package org.codehaus.preon.util;


/*package org.codehaus.preon.util;

import junit.framework.TestCase;

public class NestedClassSupportingReferenceResolverTest extends TestCase {

    public void testOuterReferences() {
        Test outer = new Test();
        Test.Inner inner = outer.new Inner();
        NestedClassSupportingReferenceResolver resolver = new NestedClassSupportingReferenceResolver(
                Test.class);
        assertEquals("inner", resolver.resolve(inner, "innerAttribute"));
        assertEquals("outer", resolver.resolve(inner, "enclosing",
                "outerAttribute"));
    }

    public static class Test {

        private String outerAttribute = "outer";

        public class Inner {

            private String innerAttribute = "inner";

        }

    }

}
*/