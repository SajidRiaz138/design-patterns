package org.behavioral.visitor.documentprocessing.elements;

import org.behavioral.visitor.documentprocessing.elements.DocumentElement;
import org.behavioral.visitor.documentprocessing.visitors.DocumentVisitor;

public class ImageElement implements DocumentElement
{
    private String imageUrl;

    public ImageElement(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public void accept(DocumentVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String getContent()
    {
        return "Image: " + imageUrl;
    }
}
