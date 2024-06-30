package org.behavioral.visitor.treetraversal.visitors;

import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class SumVisitor implements NodeVisitor
{
    private int sum = 0;

    @Override
    public void visit(TreeNode node)
    {
        int value = node.getValue();
        sum += value;
    }

    public int getSum()
    {
        return sum;
    }
}
