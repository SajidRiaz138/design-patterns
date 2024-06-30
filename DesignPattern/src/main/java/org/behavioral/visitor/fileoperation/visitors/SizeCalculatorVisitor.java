package org.behavioral.visitor.fileoperation.visitors;

import org.behavioral.visitor.fileoperation.elements.Directory;
import org.behavioral.visitor.fileoperation.elements.File;

public class SizeCalculatorVisitor implements FileSystemVisitor
{
    private int totalSize = 0;

    @Override
    public void visit(File file)
    {
        totalSize += file.getSize();
    }

    public int getTotalSize()
    {
        return totalSize;
    }
}
