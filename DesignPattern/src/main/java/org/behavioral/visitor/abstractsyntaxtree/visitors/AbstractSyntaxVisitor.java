package org.behavioral.visitor.abstractsyntaxtree.visitors;

import org.behavioral.visitor.abstractsyntaxtree.elements.ExpressionNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.LiteralNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.StatementNode;
import org.behavioral.visitor.abstractsyntaxtree.elements.VariableNode;

public interface AbstractSyntaxVisitor
{
    void visit(ExpressionNode node);

    void visit(StatementNode node);

    void visit(VariableNode node);

    void visit(LiteralNode node);
}
