package com.krutova.texthandling.main;

import java.util.Comparator;

import com.krutova.texthandling.action.TextAction;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;
import com.krutova.texthandling.exception.TextException;
import com.krutova.texthandling.filemanager.ReadTextFromFile;
import com.krutova.texthandling.sort.SentenceSort;
import com.krutova.texthandling.parser.TextParser;

public class TextMain {
	
	private final static String FILE_NAME = "data\\Text.txt";
	
	public static void main(String[] args){

		String textString=null;
		try {
			textString = ReadTextFromFile.readTextFromFile(FILE_NAME);
		} catch (TextException e) {
			e.printStackTrace();
		}

		TextComposite composite = new TextComposite();
		TextParser parser = new TextParser();
		
		parser.parser(textString, composite);

		SentenceSort sent = new SentenceSort();
		
		sent.sortSentenceList(TextAction.listOfComponent(TextComponentType.SENTENCE,composite));
		//Get sorted Sentences by countwoeds
		sent.getSortSentenceList().entrySet().stream().sorted(Comparator.comparing(e -> e.getKey())).forEach(System.out::println);
		
	}
}
