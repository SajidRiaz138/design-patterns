package org.behavioral.visitor.fileoperation.visitors;

import org.behavioral.visitor.fileoperation.elements.Directory;
import org.behavioral.visitor.fileoperation.elements.File;

public class ReportGeneratorVisitor implements FileSystemVisitor
{
    private StringBuilder report = new StringBuilder();

    @Override
    public void visit(File file)
    {
        report.append("File: ").append(file.getName()).append(" (").append(file.getSize()).append(" bytes)\n");
    }

    @Override
    public void visit(Directory directory)
    {
        report.append("Directory: ").append(directory.getName()).append("\n");
    }

    public String getReport()
    {
        return report.toString();
    }
}
