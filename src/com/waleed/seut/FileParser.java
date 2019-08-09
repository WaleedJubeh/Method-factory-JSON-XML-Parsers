package com.waleed.seut;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class FileParser {

    public abstract void ParseString(String json_string) throws ParseException;

}
