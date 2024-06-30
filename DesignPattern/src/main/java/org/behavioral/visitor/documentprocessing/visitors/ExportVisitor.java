package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;

public class ExportVisitor implements DocumentVisitor
{
    @Override
    public void visit(TextElement textElement)
    {
        System.out.println("Exporting text: " + textElement.getContent());
        // Add export logic here
    }

    @Override
    public void visit(ImageElement imageElement)
    {
        System.out.println("Exporting image: " + imageElement.getContent());
        // Add export logic here
    }

    @Override
    public void visit(TableElement tableElement)
    {
        System.out.println("Exporting table: \n" + tableElement.getContent());
        // Add export logic here
    }
}
