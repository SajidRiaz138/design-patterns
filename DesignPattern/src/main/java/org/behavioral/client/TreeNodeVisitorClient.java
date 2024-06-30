package org.behavioral.client;

import org.behavioral.visitor.treetraversal.visitors.AverageValueVisitor;
import org.behavioral.visitor.treetraversal.visitors.DepthVisitor;
import org.behavioral.visitor.treetraversal.visitors.MaxValueVisitor;
import org.behavioral.visitor.treetraversal.visitors.NodeCounterVisitor;
import org.behavioral.visitor.treetraversal.traversalstrategies.PostOrderTraversal;
import org.behavioral.visitor.treetraversal.traversalstrategies.PreOrderTraversal;
import org.behavioral.visitor.treetraversal.visitors.SumVisitor;
import org.behavioral.visitor.treetraversal.elements.Tree;
import org.behavioral.visitor.treetraversal.elements.TreeNode;

public class TreeNodeVisitorClient
{

    public static void main(String... args)
    {
        TreeNode left = new TreeNode(8, null, null);
        TreeNode right = new TreeNode(9, null, null);

        left = new TreeNode(6, left, right);
        right = new TreeNode(7, null, null);
        TreeNode root = new TreeNode(5, left, right);

        Tree tree = new Tree(root);

        SumVisitor sumVisitor = new SumVisitor();
        tree.accept(sumVisitor, new PreOrderTraversal());
        System.out.println("Sum of all node values by pre-order traversal : " + sumVisitor.getSum());

        NodeCounterVisitor nodeCounterVisitor = new NodeCounterVisitor();
        tree.accept(nodeCounterVisitor, new PreOrderTraversal());
        System.out.println("Total number of nodes in Tree : " + nodeCounterVisitor.getCount());

        MaxValueVisitor maxValueVisitor = new MaxValueVisitor();
        tree.accept(maxValueVisitor, new PreOrderTraversal());
        System.out.println("Maximum number in given Tree : " + maxValueVisitor.getMaxValue());

        DepthVisitor depthVisitor = new DepthVisitor();
        tree.accept(depthVisitor, new PreOrderTraversal());
        System.out.println("Maximum depth of tree (Pre-Order): " + depthVisitor.getMaxDepth());

        AverageValueVisitor averageValueVisitor = new AverageValueVisitor();
        tree.accept(averageValueVisitor, new PostOrderTraversal());
        System.out.println("Average value of nodes (Post-Order): " + averageValueVisitor.getAverage());

    }
}
