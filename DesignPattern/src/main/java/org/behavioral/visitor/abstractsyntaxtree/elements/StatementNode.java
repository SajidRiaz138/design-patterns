package org.behavioral.visitor.abstractsyntaxtree.elements;

import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxVisitor;

public class StatementNode implements AbstractSyntaxTree
{
    private String statement;

    public StatementNode(String statement)
    {
        this.statement = statement;
    }

    public String getStatement()
    {
        return statement;
    }

    @Override
    public void accept(AbstractSyntaxVisitor visitor)
    {
        visitor.visit(this);
    }
}
