package org.behavioral.visitor.treetraversal.traversalstrategies;

import org.behavioral.visitor.treetraversal.elements.TreeNode;
import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public class InOrderTraversal implements TraversalStrategy
{
    @Override
    public void traverse(TreeNode node, NodeVisitor visitor)
    {
        if (node != null)
        {
            traverse(node.getLeft(), visitor);
            node.accept(visitor);
            traverse(node.getRight(), visitor);
        }
    }
}
