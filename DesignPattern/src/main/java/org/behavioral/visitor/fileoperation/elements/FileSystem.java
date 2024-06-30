package org.behavioral.visitor.fileoperation.elements;

import org.behavioral.visitor.fileoperation.visitors.FileSystemVisitor;

import java.util.ArrayList;
import java.util.List;

public class FileSystem
{
    private List<FileSystemNode> nodes;

    public FileSystem()
    {
        this.nodes = new ArrayList<>();
    }

    public void addNode(FileSystemNode node)
    {
        nodes.add(node);
    }

    public void accept(FileSystemVisitor visitor)
    {
        for (FileSystemNode node : nodes)
        {
            node.accept(visitor);
        }
    }
}
