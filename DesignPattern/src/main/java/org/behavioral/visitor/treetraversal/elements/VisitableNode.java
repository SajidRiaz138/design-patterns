package org.behavioral.visitor.treetraversal.elements;

import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public interface VisitableNode
{
    void accept(NodeVisitor visitor);
}
