package org.behavioral.visitor.abstractsyntaxtree.visitors;

import org.behavioral.visitor.abstractsyntaxtree.elements.ExpressionNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.LiteralNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.StatementNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.VariableNode;

import java.util.HashMap;
import java.util.Map;

public class TypeCheckerVisitor implements AbstractSyntaxVisitor
{
    private Map<String, String> variableTypes = new HashMap<>();

    @Override
    public void visit(ExpressionNode node)
    {
        // Assuming a very simple expression checker that just prints the expression
        System.out.println("Type checking expression: " + node.getExpression());
    }

    @Override
    public void visit(StatementNode node)
    {
        // Type checking statements like variable declarations
        String statement = node.getStatement();
        if (statement.matches("int\\s+\\w+\\s*=\\s*\\d+;"))
        {
            String[] parts = statement.split("\\s+");
            variableTypes.put(parts[1], "int");
            System.out.println("Declared variable " + parts[1] + " with type int");
        }
        else
        {
            System.out.println("Unknown statement type: " + statement);
        }
    }

    @Override
    public void visit(VariableNode node)
    {
        String variableName = node.getVariableName();
        if (variableTypes.containsKey(variableName))
        {
            System.out.println("Variable " + variableName + " is defined with type " + variableTypes.get(variableName));
        }
        else
        {
            System.out.println("Type checking error: Undefined variable " + variableName);
        }
    }

    @Override
    public void visit(LiteralNode node)
    {
        System.out.println("Literal of type " + node.getType() + " with value " + node.getValue());
    }
}
