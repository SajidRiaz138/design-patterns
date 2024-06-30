package org.behavioral.visitor.treetraversal.visitors;

import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class AverageValueVisitor implements NodeVisitor
{
    private int sum = 0;
    private int count = 0;

    @Override
    public void visit(TreeNode node)
    {
        sum = sum + node.getValue();
        count++;
    }

    public double getAverage()
    {
        return count == 0 ? 0 : (double) sum / count;
    }
}
