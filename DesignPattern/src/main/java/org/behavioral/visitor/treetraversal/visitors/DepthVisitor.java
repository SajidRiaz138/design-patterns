package org.behavioral.visitor.treetraversal.visitors;

import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class DepthVisitor implements NodeVisitor
{
    private int maxDepth = 0;
    private int currentDepth = 0;

    @Override
    public void visit(TreeNode node)
    {
        currentDepth++;
        if (node.getLeft() == null && node.getRight() == null)
        {
            if (currentDepth > maxDepth)
            {
                maxDepth = currentDepth;
            }
        }
        if (node.getLeft() != null)
        {
            visit(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visit(node.getRight());
        }
        currentDepth--;
    }

    public int getMaxDepth()
    {
        return maxDepth;
    }
}
