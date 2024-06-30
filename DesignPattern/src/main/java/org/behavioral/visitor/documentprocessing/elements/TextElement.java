package org.behavioral.visitor.documentprocessing.elements;

import org.behavioral.visitor.documentprocessing.visitors.DocumentVisitor;

public class TextElement implements DocumentElement
{
    private String text;

    public TextElement(String text)
    {
        this.text = text;
    }

    @Override
    public void accept(DocumentVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String getContent()
    {
        return text;
    }
}
