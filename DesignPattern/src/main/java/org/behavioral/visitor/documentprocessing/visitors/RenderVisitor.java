package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;

public class RenderVisitor implements DocumentVisitor
{
    @Override
    public void visit(TextElement textElement)
    {
        System.out.println("Rendering text: " + textElement.getContent());
    }

    @Override
    public void visit(ImageElement imageElement)
    {
        System.out.println("Rendering image from URL: " + imageElement.getContent());
    }

    @Override
    public void visit(TableElement tableElement)
    {
        System.out.println("Rendering table: \n" + tableElement.getContent());
    }
}
