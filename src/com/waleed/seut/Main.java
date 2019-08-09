package com.waleed.seut;

import org.apache.xmlbeans.XmlOptions;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.crypto.dsig.XMLValidateContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.validation.Validator;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, XMLStreamException {
	// write your code here

        XMLFileParser jsonParser=new XMLFileParser();
        jsonParser.ParseString("SI2.xml");
    }
}
