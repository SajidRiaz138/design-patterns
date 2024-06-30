package org.behavioral.visitor.abstractsyntaxtree.elements;

import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxVisitor;

public class ExpressionNode implements AbstractSyntaxTree
{
    private String expression;

    public ExpressionNode(String expression)
    {
        this.expression = expression;
    }

    public String getExpression()
    {
        return expression;
    }

    @Override
    public void accept(AbstractSyntaxVisitor visitor)
    {
        visitor.visit(this);
    }
}
