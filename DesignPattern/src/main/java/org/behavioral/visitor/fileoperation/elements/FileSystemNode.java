package org.behavioral.visitor.fileoperation.elements;

import org.behavioral.visitor.fileoperation.visitors.FileSystemVisitor;

public interface FileSystemNode
{
    void accept(FileSystemVisitor visitor);

    String getName();
}
