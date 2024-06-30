package org.behavioral.visitor.abstractsyntaxtree.elements;

import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxVisitor;

public class VariableNode implements AbstractSyntaxTree
{
    private String variableName;
    private String type;

    public VariableNode(String variableName, String type)
    {
        this.variableName = variableName;
        this.type = type;
    }

    public String getVariableName()
    {
        return variableName;
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
