package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;

import java.util.HashSet;
import java.util.Set;

public class SpellCheckVisitor implements DocumentVisitor
{
    private Set<String> dictionary;

    public SpellCheckVisitor()
    {
        this.dictionary = new HashSet<>();
        // Example dictionary words
        dictionary.add("Hello");
        dictionary.add("this");
        dictionary.add("is");
        dictionary.add("a");
        dictionary.add("text");
        dictionary.add("element");
        // Add more words as needed
    }

    @Override
    public void visit(TextElement textElement)
    {
        spellCheck(textElement.getContent());
    }

    @Override
    public void visit(ImageElement imageElement)
    {
        // No spell checking needed for images
    }

    @Override
    public void visit(TableElement tableElement)
    {
        spellCheck(tableElement.getContent());
    }

    private void spellCheck(String content)
    {
        String[] words = content.split("\\s+");
        for (String word : words)
        {
            if (!dictionary.contains(word))
            {
                System.out.println("Misspelled word: " + word);
            }
        }
    }
}
