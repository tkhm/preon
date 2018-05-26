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

import org.antlr.runtime.RecognitionException;
import org.codehaus.preon.el.ctx.VariableContext;
import org.codehaus.preon.el.ctx.VariableDefinitions;
import org.codehaus.preon.el.ctx.VariableResolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LimboTest {

    private VariableResolver resolver;

    private VariableDefinitions defs;

    private VariableContext context;

    @Before
    public void setUp() throws Exception {
        resolver = mock(VariableResolver.class);
        defs = mock(VariableDefinitions.class);
        context = new VariableContext(defs);
    }

    @Test
    public void testUnderscores() {
        when(resolver.get("FOO_BAR")).thenReturn(12);
        when(defs.getType("FOO_BAR")).thenReturn(Integer.class);

        assertEquals(12, arithmetic(context, resolver, "FOO_BAR"));
    }

    @Test
    public void testBinaryNotation() throws RecognitionException, InvalidExpressionException {
        assertEquals(3, arithmetic(context, resolver, "0b11"));
        assertEquals(5, arithmetic(context, resolver, "0b101"));
    }

    @Test
    public void testHexidecimalNotation() throws RecognitionException, InvalidExpressionException {
        assertEquals(255, arithmetic(context, resolver, "0xff"));
        assertEquals(16, arithmetic(context, resolver, "0x10"));
    }

    @Test
    public void testPow() throws RecognitionException, InvalidExpressionException {
        when(resolver.get("a")).thenReturn(Integer.valueOf(3));
        when(defs.getType("a")).thenReturn(Integer.class);

        assertEquals(8, arithmetic(context, resolver, "2^a"));
        assertEquals(9, arithmetic(context, resolver, "a^2"));
        assertEquals(27, arithmetic(context, resolver, "a^a"));
        assertEquals(9, arithmetic(context, resolver, "a^(a-1)"));
        assertEquals(26, arithmetic(context, resolver, "a ^ a -1"));
    }

    @Test
    public void testSimpleCondition() throws RecognitionException, InvalidExpressionException {
        assertTrue(condition(context, resolver, "3 > 2"));
    }

    @Test
    public void testComplexConditions() throws RecognitionException, InvalidExpressionException {
        assertTrue(condition(context, resolver, "3 > 2 && 2 > 1"));
        assertFalse(condition(context, resolver, "3 > 2 && 1 > 2"));
        assertTrue(condition(context, resolver, "3 > 2 || 1 > 2"));
        assertTrue(condition(context, resolver, "1 > 2 || 2 > 3 || 4 > 3"));
        assertFalse(condition(context, resolver, "1 > 2 || (4 > 3 && 2 < 2)"));
    }

    @Test
    public void testDivision() throws RecognitionException, InvalidExpressionException {
        assertEquals(2, arithmetic(context, resolver, "4/2"));
        assertEquals(2, arithmetic(context, resolver, "5/2"));
        assertEquals(3, arithmetic(context, resolver, "6/2"));
    }

    @Test
    public void testSimpleAddition() throws RecognitionException, InvalidExpressionException {
        assertEquals(8, arithmetic(context, resolver, "5 + 3"));
    }

    @Test
    public void testOperatorPrecedence() throws RecognitionException, InvalidExpressionException {
        assertEquals(arithmetic(context, resolver, "5 + 3 * 4"), arithmetic(context, resolver,
                "3 * 4 + 5"));
    }

    @Test
    public void testBooleans() throws RecognitionException, InvalidExpressionException {
        when(resolver.get("foo")).thenReturn(true);
        when(defs.getType("foo")).thenReturn(Boolean.class);
        when(resolver.get("bar")).thenReturn(false);
        when(defs.getType("bar")).thenReturn(Boolean.class);

        assertTrue(condition(context, resolver, "true"));
        assertFalse(condition(context, resolver, "false"));
        assertTrue(condition(context, resolver, "true == foo"));
    }

    @Test(expected=InvalidExpressionException.class)
    public void testParserProblemArithmetic() {
        when(defs.getType("a")).thenReturn(Integer.class);
        // Previously asserted that "b" would also be checked, but a different
        // ANTLR generated code path negates that now.

        Expression<Integer, VariableResolver> expr = Expressions.createInteger(context, "a - * b");
    }

    @Test
    public void testWithSimpleReference() throws RecognitionException, InvalidExpressionException {
        when(resolver.get("a")).thenReturn(Integer.valueOf(3));
        when(defs.getType("a")).thenReturn(Integer.class);

        assertEquals(8, arithmetic(context, resolver, "5 + a"));
    }

    @Test
    public void testWithComplexReference() throws RecognitionException, InvalidExpressionException {
        Sample test = new Sample();
        test.b = new Sample();
        test.b.c = 3;
        when(resolver.get("a")).thenReturn(test);
        when(defs.getType("a")).thenReturn(Sample.class);

        assertEquals(8, arithmetic(context, resolver, "5 + a.b.c"));
    }

    @Test
    public void testIntegerComparison() {
        Expression<Boolean, VariableResolver> expr = Expressions.createBoolean(context, "5 == 5");
        assertTrue(expr.eval(resolver));
    }

    @Test
    public void testStringComparison() {
        Expression<Boolean, VariableResolver> expr = Expressions.createBoolean(context,
                "'abc' == 'abc'");
        assertTrue(expr.eval(resolver));
        assertFalse(Expressions.createBoolean(context, "'abc' == 'cba'").eval(resolver));
    }

    @Test
    public void testExpressionsCreate() {
        Expression<Object, VariableResolver> expr = Expressions.create(context, "23");
        assertEquals(23, expr.eval(resolver));
    }

    @Test
    public void testStringLiterals() {
        Expression<Object, VariableResolver> expr = Expressions.create(context, "'abc'");
        assertEquals("abc", expr.eval(resolver));
    }
    
    @Test
    public void testStringReferencesResolution() {
        when(resolver.get("a")).thenReturn("Whatever");

        Expression<Object, VariableResolver> expr = Expressions.create(context, "a");
        assertEquals("Whatever", expr.eval(resolver));
    }
    
    @Test(expected=BindingException.class)
    public void testAddingStrings() {
        when(defs.getType("a")).thenReturn(String.class);


        Expression<Object, VariableResolver> expr = Expressions.create(context, "a > 3");
    }

    @Test
    public void testComparingEnums() {
    	when(defs.getType("a")).thenReturn(Direction.class);
    	when(defs.getType("b")).thenReturn(Direction.class);
    	when(resolver.get("a")).thenReturn(Direction.LEFT);
    	when(resolver.get("b")).thenReturn(Direction.RIGHT);

    	assertTrue(condition(context, resolver, "a == a"));
    	assertFalse(condition(context, resolver, "a == b"));
    	assertTrue(condition(context, resolver, "b == b"));
    }
    
    private <E> int arithmetic(ReferenceContext<VariableResolver> context,
            VariableResolver resolver, String exprString) throws InvalidExpressionException {
        Expression<Integer, VariableResolver> expr = Expressions.createInteger(context, exprString);
        return expr.eval(resolver);
    }

    private <E> boolean condition(ReferenceContext<VariableResolver> context,
            VariableResolver resolver, String exprString) throws InvalidExpressionException {
        Expression<Boolean, VariableResolver> expr = Expressions.createBoolean(context, exprString);
        return expr.eval(resolver);
    }

    private static class Sample {

        Sample b;

        int c;

    }
    
    public enum Direction {
    	LEFT, 
    	RIGHT;
    	
    }

}
