package org.behavioral.visitor.documentprocessing.visitors;

import org.behavioral.visitor.documentprocessing.elements.ImageElement;
import org.behavioral.visitor.documentprocessing.elements.TableElement;
import org.behavioral.visitor.documentprocessing.elements.TextElement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonExportVisitor implements DocumentVisitor
{
    private JSONArray jsonDocument = new JSONArray();

    @Override
    public void visit(TextElement textElement)
    {
        JSONObject jsonText = new JSONObject();
        jsonText.put("type", "text");
        jsonText.put("content", textElement.getContent());
        jsonDocument.put(jsonText);
    }

    @Override
    public void visit(ImageElement imageElement)
    {
        JSONObject jsonImage = new JSONObject();
        jsonImage.put("type", "image");
        jsonImage.put("url", imageElement.getContent().substring(7));
        jsonDocument.put(jsonImage);
    }

    @Override
    public void visit(TableElement tableElement)
    {
        JSONObject jsonTable = new JSONObject();
        jsonTable.put("type", "table");
        JSONArray rows = new JSONArray();
        for (List<String> row : tableElement.getTableData())
        {
            JSONArray jsonRow = new JSONArray(row);
            rows.put(jsonRow);
        }
        jsonTable.put("data", rows);
        jsonDocument.put(jsonTable);
    }

    public String getJson()
    {
        return jsonDocument.toString(2);
    }
}
