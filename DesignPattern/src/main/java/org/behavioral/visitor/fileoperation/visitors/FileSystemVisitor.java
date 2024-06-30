package org.behavioral.visitor.fileoperation.visitors;

import org.behavioral.visitor.fileoperation.elements.Directory;
import org.behavioral.visitor.fileoperation.elements.File;

public interface FileSystemVisitor
{
    void visit(File file);

    default void visit(Directory directory){};
}
