package org.behavioral.visitor.treetraversal.traversalstrategies;

import org.behavioral.visitor.treetraversal.elements.TreeNode;
import org.behavioral.visitor.treetraversal.visitors.NodeVisitor;

public interface TraversalStrategy
{
    void traverse(TreeNode node, NodeVisitor visitor);
}
