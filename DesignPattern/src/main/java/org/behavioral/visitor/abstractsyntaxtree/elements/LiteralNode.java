package org.behavioral.visitor.abstractsyntaxtree.elements;

import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxVisitor;

public class LiteralNode implements AbstractSyntaxTree
{
    private String value;
    private String type;

    public LiteralNode(String value, String type)
    {
        this.value = value;
        this.type = type;
    }

    public String getValue()
    {
        return value;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public void accept(AbstractSyntaxVisitor visitor)
    {
        visitor.visit(this);
    }
}
