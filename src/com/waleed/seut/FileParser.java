package com.waleed.seut;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class FileParser {

    public abstract void ParseString(String code,String result) throws ParseException;
    String readFile(String path) throws IOException {
        Stream<String> x= Files.lines(Paths.get(path), StandardCharsets.UTF_8);
        Object[] lines= x.toArray();
        String result="";
        for(int i=0; i<lines.length;i++)
        {
            result+=lines[i];
        }
        return result;
    }
}
