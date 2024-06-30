package org.behavioral.visitor.abstractsyntaxtree.visitors;

import org.behavioral.visitor.abstractsyntaxtree.elements.ExpressionNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.LiteralNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.StatementNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.VariableNode;

public class OptimizerVisitor implements AbstractSyntaxVisitor
{
    @Override
    public void visit(ExpressionNode node)
    {
        // Simple optimization: constant folding
        String expression = node.getExpression();
        if (expression.matches("\\d+\\s*\\+\\s*\\d+"))
        {
            String[] parts = expression.split("\\+");
            int result = Integer.parseInt(parts[0].trim()) + Integer.parseInt(parts[1].trim());
            node = new ExpressionNode(String.valueOf(result));
            System.out.println("Optimized expression to: " + node.getExpression());
        }
        else
        {
            System.out.println("Expression does not require optimization: " + expression);
        }
    }

    @Override
    public void visit(StatementNode node)
    {
        System.out.println("Optimizing statement: " + node.getStatement());
        // Add statement optimization logic here
    }

    @Override
    public void visit(VariableNode node)
    {
        System.out.println("Optimizing variable: " + node.getVariableName());
        // Add variable optimization logic here
    }

    @Override
    public void visit(LiteralNode node)
    {
        System.out.println("Optimizing literal: " + node.getValue());
        // Add literal optimization logic here
    }
}
