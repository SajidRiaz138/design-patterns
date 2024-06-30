package org.behavioral.visitor.treetraversal.elements;

import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public class TreeNode implements VisitableNode
{
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue()
    {
        return value;
    }

    public TreeNode getLeft()
    {
        return left;
    }

    public TreeNode getRight()
    {
        return right;
    }

    @Override
    public void accept(NodeVisitor visitor)
    {
        visitor.visit(this);
    }
}
