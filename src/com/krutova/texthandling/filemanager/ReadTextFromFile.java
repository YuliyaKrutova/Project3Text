package com.krutova.texthandling.filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.krutova.texthandling.textexception.TextException;

public class ReadTextFromFile {
	
	public static String readTextFromFile(String fileName) throws  TextException {

		String line=null;
		try{
		line=Files.lines(Paths.get(fileName)).collect(Collectors.joining("\n"));
        }        
        catch(IOException  e){
			throw new TextException("File is incorrect",e);
		}
        if (line.isEmpty() ){
        	throw new TextException("File is empty!");
        }
	return line;
	}
}
