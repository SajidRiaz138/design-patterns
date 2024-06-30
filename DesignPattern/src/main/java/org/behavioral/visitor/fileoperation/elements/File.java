package org.behavioral.visitor.fileoperation.elements;

import org.behavioral.visitor.fileoperation.visitors.FileSystemVisitor;

public class File implements FileSystemNode
{
    private String name;
    private int size; // Size in bytes

    public File(String name, int size)
    {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public int getSize()
    {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor)
    {
        visitor.visit(this);
    }
}
