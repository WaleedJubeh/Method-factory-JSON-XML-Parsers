package com.waleed.seut;

import org.json.simple.parser.ParseException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
public class XMLFileParser extends FileParser {

    @Override
    public void ParseString(String path,String result) throws ParseException {
        try {
            boolean type=true;
            String xml = super.readFile(path);
            StringBuilder content = null;
            XMLInputFactory factory = XMLInputFactory.newInstance();
            InputStream stream = new ByteArrayInputStream(xml.getBytes());
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            FileWriter output = null;
            try {
                output=new FileWriter(result);
            } catch (Exception e) {
                System.out.println("Error");
                return;
            }
            String  end="";
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT: {
                        content = new StringBuilder();
                        if(type) {
                            String types= ((String) reader.getLocalName());
                            end=types;
                            //Capitilize the first letter of the type
                            types=types.substring(0,1).toUpperCase() + types.substring(1).toLowerCase();
                            type=false;
                            output.write("Type: " + types + "\n");
                            output.write("------------------\n");
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                        if (content != null) {
                            content.append(reader.getText().trim());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content != null) {
                            String leafText = content.toString();
                            if(!end.equals( reader.getLocalName()))
                            output.write(reader.getLocalName() + " : " + leafText+"\n");
                        }
                        content = null;
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                }

            }
            output.close();
            System.out.println("Parse Done check file "+result);
        } catch (XMLStreamException ex) {
            System.out.println("The file is not in XML format");
        } catch (IOException ex) {
            System.out.println("Error in Reading or writing on the File ");
        }
    }
}
