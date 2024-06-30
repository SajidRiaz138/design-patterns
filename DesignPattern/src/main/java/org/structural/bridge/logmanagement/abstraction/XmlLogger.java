package org.structural.bridge.logmanagement.abstraction;

import org.structural.bridge.logmanagement.implementation.LogDestination;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * The XmlLogger class provides a concrete implementation for logging messages in XML format.
 */
public class XmlLogger extends Logger
{
    public XmlLogger(LogDestination destination)
    {
        super(destination);
    }

    @Override
    public void log(String message)
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("log");
            doc.appendChild(rootElement);

            Element msg = doc.createElement("message");
            msg.appendChild(doc.createTextNode(message));
            rootElement.appendChild(msg);

            Element timestamp = doc.createElement("timestamp");
            timestamp.appendChild(doc.createTextNode(String.valueOf(System.currentTimeMillis())));
            rootElement.appendChild(timestamp);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);
            destination.sendLog(writer.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
