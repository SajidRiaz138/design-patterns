package org.behavioral.visitor.abstractsyntaxtree.visitors;

import org.behavioral.visitor.abstractsyntaxtree.elements.ExpressionNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.LiteralNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.StatementNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.VariableNode;

public class CodeGeneratorVisitor implements AbstractSyntaxVisitor
{
    private StringBuilder code = new StringBuilder();

    @Override
    public void visit(ExpressionNode node)
    {
        code.append(node.getExpression()).append(";\n");
    }

    @Override
    public void visit(StatementNode node)
    {
        code.append(node.getStatement()).append("\n");
    }

    @Override
    public void visit(VariableNode node)
    {
        code.append(node.getType()).append(" ").append(node.getVariableName()).append(";\n");
    }

    @Override
    public void visit(LiteralNode node)
    {
        code.append(node.getValue()).append(";\n");
    }

    public String getCode()
    {
        return code.toString();
    }
}
