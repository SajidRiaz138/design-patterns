package org.behavioral.visitor.abstractsyntaxtree.elements;

import org.behavioral.visitor.abstractsyntaxtree.visitors.AbstractSyntaxVisitor;

public interface AbstractSyntaxTree
{
    void accept(AbstractSyntaxVisitor visitor);
}
