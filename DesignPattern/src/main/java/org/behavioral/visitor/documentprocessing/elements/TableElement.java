package org.behavioral.visitor.documentprocessing.elements;

import org.behavioral.visitor.documentprocessing.elements.DocumentElement;
import org.behavioral.visitor.documentprocessing.visitors.DocumentVisitor;

import java.util.List;

public class TableElement implements DocumentElement
{
    private List<List<String>> tableData;

    public TableElement(List<List<String>> tableData)
    {
        this.tableData = tableData;
    }

    @Override
    public void accept(DocumentVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String getContent()
    {
        StringBuilder content = new StringBuilder();
        for (List<String> row : tableData)
        {
            for (String cell : row)
            {
                content.append(cell).append("\t");
            }
            content.append("\n");
        }
        return content.toString();
    }

    public List<List<String>> getTableData()
    {
        return tableData;
    }
}
