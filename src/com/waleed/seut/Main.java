package com.waleed.seut;
import org.json.simple.parser.ParseException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException, ParseException, XMLStreamException {
	// write your code here
        Scanner cin= new Scanner(System.in);
        JSONFileParser jsonParser=new JSONFileParser();
        XMLFileParser  xmlParser=new XMLFileParser();
        int choice;
        do{
            System.out.println("Welcome to JSON-XML Simple Parsers ");
            System.out.println("\t1-Parse a json file");
            System.out.println("\t2-Parse a XML file");
            System.out.println("\t3-Exit");
            System.out.print("Your Choice : ");
            try{choice = cin.nextInt();}
            catch (Exception e)
            {
                System.out.println("Stop playing with me");
                choice=3;

            }
            cin.nextLine();

            switch (choice)
            {
                case 1:
                    {
                    String fileName = "";
                    String result = "";
                    System.out.println("Enter json file name (with extension) : ");
                    fileName = cin.nextLine();
                    System.out.println("Enter Result file name (with extension) : ");
                    result = cin.nextLine();
                    jsonParser.ParseString(fileName, result);
                    break;
                }
                case 2: {
                    String fileName = "";
                    String result = "";
                    System.out.println("Enter XML file name (with extension) : ");
                    fileName = cin.nextLine();
                    System.out.println("Enter XML file name (with extension) : ");
                    result = cin.nextLine();
                    xmlParser.ParseString(fileName, result);
                    break;
                }
                default:
                    System.exit(0);
            }
        }while(choice>0);
    }
}
