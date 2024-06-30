package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;

public interface DocumentVisitor
{
    void visit(TextElement textElement);

    void visit(ImageElement imageElement);

    void visit(TableElement tableElement);

}
