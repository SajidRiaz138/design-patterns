package org.behavioral.visitor.treetraversal.visitors;

import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class NodeCounterVisitor implements NodeVisitor
{
    private int counter = 0;

    @Override
    public void visit(TreeNode node)
    {
        counter++;
    }

    public int getCount()
    {
        return counter;
    }
}
