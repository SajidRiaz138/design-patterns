package org.behavioral.visitor.abstractsyntaxtree.visitors;

import org.behavioral.visitor.abstractsyntaxtree.elements.AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.List;

public class AbstractSyntaxTreeContext
{
    private List<AbstractSyntaxTree> nodes;

    public AbstractSyntaxTreeContext() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(AbstractSyntaxTree node)
    {
        nodes.add(node);
    }

    public void accept(AbstractSyntaxVisitor visitor)
    {
        for (AbstractSyntaxTree node : nodes)
        {
            node.accept(visitor);
        }
    }
}
