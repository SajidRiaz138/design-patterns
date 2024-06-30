package org.behavioral.client;

import org.behavioral.visitor.abstractsyntaxtree.elements.ExpressionNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.LiteralNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.StatementNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.VariableNode;
import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxTreeContext;
import org.behavioral.visitor.abstractsyntaxtree.visitors.CodeGeneratorVisitor;
import org.behavioral.visitor.abstractsyntaxtree.visitors.OptimizerVisitor;
import org.behavioral.visitor.abstractsyntaxtree.visitors.TypeCheckerVisitor;

public class AbstractSyntaxTreeClient
{
    public static void main(String[] args)
    {
        AbstractSyntaxTreeContext ast = new AbstractSyntaxTreeContext();

        ExpressionNode expr1 = new ExpressionNode("2 + 3");
        StatementNode stmt1 = new StatementNode("int a = 5;");
        VariableNode var1 = new VariableNode("a", "int");
        LiteralNode lit1 = new LiteralNode("5", "int");

        ast.addNode(expr1);
        ast.addNode(stmt1);
        ast.addNode(var1);
        ast.addNode(lit1);

        TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
        typeChecker.visit(stmt1); // This should be called directly to populate the variable set
        ast.accept(typeChecker);

        CodeGeneratorVisitor codeGenerator = new CodeGeneratorVisitor();
        ast.accept(codeGenerator);
        System.out.println("\nGenerated Code:");
        System.out.println(codeGenerator.getCode());

        OptimizerVisitor optimizer = new OptimizerVisitor();
        ast.accept(optimizer);
    }
}
