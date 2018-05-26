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
package org.codehaus.preon.el.ast;

import org.codehaus.preon.el.BindingException;
import org.codehaus.preon.el.Reference;
import org.codehaus.preon.el.ReferenceContext;
import org.codehaus.preon.el.util.ClassUtils;

import java.util.Set;

/**
 * The node representing (part of) an expression that translates to a boolean
 * value, based on two integer-type of nodes passed in.
 * 
 * @author Wilfred Springer
 * 
 */
public class RelationalNode<T extends Comparable<T>, E> extends
        AbstractNode<Boolean, E> {

    public enum Relation {
        GT {
            <T, E> boolean holds(E context, Node<T, E> a, Node<T, E> b) {
                return a.compareTo(context, b) > 0;
            }
        },
        GTE {
            <T, E> boolean holds(E context, Node<T, E> a, Node<T, E> b) {
                return a.compareTo(context, b) >= 0;
            }
        },
        EQ {
            <T, E> boolean holds(E context, Node<T, E> a, Node<T, E> b) {
                return a.compareTo(context, b) == 0;
            }
        },
        LT {
            <T, E> boolean holds(E context, Node<T, E> a, Node<T, E> b) {
                return a.compareTo(context, b) < 0;
            }
        },
        LTE {
            <T, E> boolean holds(E context, Node<T, E> a, Node<T, E> b) {
                return a.compareTo(context, b) <= 0;
            }
        };

        abstract <T, E> boolean holds(E context, Node<T, E> lhs, Node<T, E> rhs);
    }

    /**
     * The relationship that needs to be evaluated.
     */
    private Relation relation;

    /**
     * The left-hand side of the expression.
     */
    private Node<T, E> lhs;

    /**
     * The right-hand side of the expression.
     */
    private Node<T, E> rhs;

    /**
     * Constructs a new instance.
     * 
     * @param relation
     *            The relationship that needs to be evaluated.
     * @param lhs
     *            The left-hand side of the expression.
     * @param rhs
     *            The right-hand side of the expression.
     */
    public RelationalNode(Relation relation, Node<T, E> lhs, Node<T, E> rhs) {
        this.relation = relation;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    // JavaDoc inherited
    public Boolean eval(E context) {
        return relation.holds(context, lhs, rhs);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.preon.el.ast.Node#getType()
     */
    public Class<Boolean> getType() {
        return Boolean.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.preon.el.ast.Node#simplify()
     */
    public Node<Boolean, E> simplify() {
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.preon.el.ast.Node#gather(java.util.Set)
     */
    public void gather(Set<Reference<E>> references) {
        lhs.gather(references);
        rhs.gather(references);
    }

    public boolean isParameterized() {
        return lhs.isParameterized() || rhs.isParameterized();
    }

    public static <E, T extends Comparable<T>> RelationalNode<T, E> create(
            Relation operator, Node<?, E> lhs, Node<?, E> rhs) {

        // Warning, highly experimental piece of code following.
        // This is to 'reduce' mult references to their corresponding types
        Class<?> rhsType = rhs.getType();
        Class<?> lhsType = lhs.getType();
        if (rhsType != lhsType) {
            if (rhs instanceof ReferenceNode && rhsType.isAssignableFrom(lhsType)) {
                rhs = ((ReferenceNode) rhs).narrow(lhsType);
            } else if (lhs instanceof ReferenceNode && lhsType.isAssignableFrom(rhsType)) {
                lhs = ((ReferenceNode) lhs).narrow(rhsType);
            }
        }
        Class<?> common = ClassUtils.calculateCommonSuperType(lhs.getType(),
                rhs.getType());
        if (Comparable.class.isAssignableFrom(common)) {
            Node<T, E> comparableLhs = createComparableNode(lhs);
            Node<T, E> comparableRhs = createComparableNode(rhs);
            return new RelationalNode<T, E>(operator, comparableLhs,
                    comparableRhs);
        } else {
            throw new BindingException("Incompatible types");
        }
    }

    public static <T extends Comparable<T>, E> Node<T, E> createComparableNode(
            Node<?, E> node) {
        if (!Comparable.class.isAssignableFrom(ClassUtils.getGuaranteedBoxedVersion(node.getType()))) {
            throw new BindingException("Reference does not resolve to Comparable.");
        } else {
            return ((Node<T, E>) node);
        }
    }

    @Override
    public boolean isConstantFor(ReferenceContext<E> context) {
        return lhs.isConstantFor(context) && rhs.isConstantFor(context);
    }

    public Node<Boolean, E> rescope(ReferenceContext<E> context) {
        return new RelationalNode<T,E>(relation, lhs.rescope(context), rhs.rescope(context));
    }
}
