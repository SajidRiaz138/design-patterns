package org.behavioral.visitor.treetraversal.traversalstrategies;

import org.behavioral.visitor.treetraversal.elements.TreeNode;
import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public class PostOrderTraversal implements TraversalStrategy
{
    @Override
    public void traverse(TreeNode node, NodeVisitor visitor)
    {
        if (node != null)
        {
            traverse(node.getLeft(), visitor);
            traverse(node.getRight(), visitor);
            node.accept(visitor);
        }
    }
}
