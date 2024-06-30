package org.behavioral.visitor.documentprocessing.elements;

import org.behavioral.visitor.documentprocessing.visitors.DocumentVisitor;

public interface DocumentElement
{
    void accept(DocumentVisitor visitor);

    String getContent();
}
