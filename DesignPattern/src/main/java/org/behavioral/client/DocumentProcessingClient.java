package org.behavioral.client;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;
import org.behavioral.visitor.documentprocessing.visitors.Document;
import org.behavioral.visitor.documentprocessing.visitors.ExportVisitor;
import org.behavioral.visitor.documentprocessing.visitors.HtmlExportVisitor;
import org.behavioral.visitor.documentprocessing.visitors.JsonExportVisitor;
import org.behavioral.visitor.documentprocessing.visitors.RenderVisitor;
import org.behavioral.visitor.documentprocessing.visitors.SpellCheckVisitor;

import java.util.Arrays;

public class DocumentProcessingClient
{
    public static void main(String[] args)
    {
        Document document = new Document();

        TextElement text1 = new TextElement("Hello, this is a text element.");
        ImageElement image1 = new ImageElement("http://example.com/image1.png");
        TableElement table1 = new TableElement(Arrays.asList(
                Arrays.asList("Header1", "Header2", "Header3"),
                Arrays.asList("Row1Col1", "Row1Col2", "Row1Col3"),
                Arrays.asList("Row2Col1", "Row2Col2", "Row2Col3")));

        document.addElement(text1);
        document.addElement(image1);
        document.addElement(table1);

        RenderVisitor renderVisitor = new RenderVisitor();
        SpellCheckVisitor spellCheckVisitor = new SpellCheckVisitor();
        ExportVisitor exportVisitor = new ExportVisitor();
        HtmlExportVisitor htmlExportVisitor = new HtmlExportVisitor();
        JsonExportVisitor jsonExportVisitor = new JsonExportVisitor();

        System.out.println("Rendering Document:");
        document.accept(renderVisitor);

        System.out.println("\nSpell Checking Document:");
        document.accept(spellCheckVisitor);

        System.out.println("\nExporting Document to Text:");
        document.accept(exportVisitor);

        System.out.println("\nExporting Document to HTML:");
        document.accept(htmlExportVisitor);

        System.out.println("\nExporting Document to JSON:");
        document.accept(jsonExportVisitor);
        System.out.println(jsonExportVisitor.getJson());
    }
}
