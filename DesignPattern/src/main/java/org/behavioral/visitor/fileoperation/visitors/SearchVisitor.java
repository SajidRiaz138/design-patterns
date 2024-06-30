package org.behavioral.visitor.fileoperation.visitors;

import org.behavioral.visitor.fileoperation.elements.Directory;
import org.behavioral.visitor.fileoperation.elements.File;
import org.behavioral.visitor.fileoperation.elements.FileSystemNode;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor
{
    private String searchTerm;
    private List<FileSystemNode> foundNodes = new ArrayList<>();

    public SearchVisitor(String searchTerm)
    {
        this.searchTerm = searchTerm;
    }

    @Override
    public void visit(File file)
    {
        if (file.getName().contains(searchTerm))
        {
            foundNodes.add(file);
        }
    }

    @Override
    public void visit(Directory directory)
    {
        if (directory.getName().contains(searchTerm))
        {
            foundNodes.add(directory);
        }
    }

    public List<FileSystemNode> getFoundNodes()
    {
        return foundNodes;
    }
}
