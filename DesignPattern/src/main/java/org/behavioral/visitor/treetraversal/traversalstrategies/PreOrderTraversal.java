package org.behavioral.visitor.treetraversal.traversalstrategies;

import org.behavioral.visitor.treetraversal.elements.TreeNode;
import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public class PreOrderTraversal implements TraversalStrategy
{
    @Override
    public void traverse(TreeNode node, NodeVisitor visitor)
    {
        if (node != null)
        {
            node.accept(visitor);
            traverse(node.getLeft(), visitor);
            traverse(node.getRight(), visitor);
        }
    }
}
