package org.behavioral.visitor.treetraversal.elements;

import org.behavioral.visitor.treetraversal.traversalstrategies.TraversalStrategy;
import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public class Tree
{
    TreeNode root;

    public Tree(TreeNode root)
    {
        this.root = root;
    }

    public void accept(NodeVisitor visitor, TraversalStrategy strategy)
    {
        strategy.traverse(root, visitor);
    }
}
