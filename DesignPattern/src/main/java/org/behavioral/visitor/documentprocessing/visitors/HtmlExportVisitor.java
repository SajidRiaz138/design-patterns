package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;

import java.util.List;

public class HtmlExportVisitor implements DocumentVisitor
{
    @Override
    public void visit(TextElement textElement)
    {
        System.out.println("<p>" + textElement.getContent() + "</p>");
    }

    @Override
    public void visit(ImageElement imageElement)
    {
        System.out.println("<img src=\"" + imageElement.getContent().substring(7) + "\" />");
    }

    @Override
    public void visit(TableElement tableElement)
    {
        StringBuilder html = new StringBuilder("<table>");
        for (List<String> row : tableElement.getTableData())
        {
            html.append("<tr>");
            for (String cell : row)
            {
                html.append("<td>").append(cell).append("</td>");
            }
            html.append("</tr>");
        }
        html.append("</table>");
        System.out.println(html.toString());
    }
}
