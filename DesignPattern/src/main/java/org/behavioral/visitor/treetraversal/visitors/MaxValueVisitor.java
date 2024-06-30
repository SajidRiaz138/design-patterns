package org.behavioral.visitor.treetraversal.visitors;

import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class MaxValueVisitor implements NodeVisitor
{
    private int maxValue = Integer.MIN_VALUE;

    @Override
    public void visit(TreeNode node)
    {
        if (node.getValue() > maxValue)
        {
            maxValue = node.getValue();
        }
    }

    public int getMaxValue()
    {
        return maxValue;
    }
}
