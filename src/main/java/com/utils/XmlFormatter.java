package com.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.StringWriter;

public class XmlFormatter {

    public static String prettyPrint(final String xml) {

        if (xml.isEmpty()) {
            throw new RuntimeException("xml was null or blank in prettyPrint()");
        }

        final StringWriter sw;

        try {

            Document doc = DocumentHelper.parseText(xml);
            sw = new StringWriter();
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setNewLineAfterDeclaration(false);
            XMLWriter xw = new XMLWriter(sw, format);
            xw.write(doc);

        } catch (Exception e) {
            throw new RuntimeException("Error pretty printing xml:\n" + xml, e);
        }
        return sw.toString();
    }

}
