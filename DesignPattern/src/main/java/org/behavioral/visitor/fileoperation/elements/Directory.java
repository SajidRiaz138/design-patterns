package org.behavioral.visitor.fileoperation.elements;

import org.behavioral.visitor.fileoperation.visitors.FileSystemVisitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemNode
{
    private String name;
    private List<FileSystemNode> children;

    public Directory(String name)
    {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName()
    {
        return name;
    }

    public List<FileSystemNode> getChildren()
    {
        return children;
    }

    public void addNode(FileSystemNode node)
    {
        children.add(node);
    }

    @Override
    public void accept(FileSystemVisitor visitor)
    {
        visitor.visit(this);
        for (FileSystemNode child : children)
        {
            child.accept(visitor);
        }
    }
}
