package sk.upjs.ics;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMReader {
    
    private UCIRoad creatReader(Element xmlReader) {
        if (!"UCIRoad".equals(xmlReader.getNodeName())) {
            throw new RuntimeException("Nekorektny element!");
        }
        return null;
    }
    
}
