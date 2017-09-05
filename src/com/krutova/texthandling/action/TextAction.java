package com.krutova.texthandling.action;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;
import com.krutova.texthandling.parser.AbstractParser;

public class TextAction {

	public static int wordCountInSentence(String sentence){
		int wordCount=0;
		Pattern lexemePattern = Pattern.compile(AbstractParser.LEXEME_REGEX);
		Matcher lexemeMatcher = lexemePattern.matcher(sentence);
		while(lexemeMatcher.find()){
			wordCount++;
		} 
		return wordCount;
	}
	
	public static ArrayList<TextComponent> listOfComponent (TextComponentType componentType, TextComposite composite){
		 ArrayList<TextComponent> returnList = new ArrayList<TextComponent>();
		for (TextComponent text: composite.getComponentList()){
			if (TextComponentType.TEXT.equals(componentType)){
				returnList.add(text);
			} else {
					for (TextComponent paragraph: ((TextComposite) text).getComponentList()){
				    	if (TextComponentType.PARAGRAPH.equals(componentType)){
				    		returnList.add(paragraph);
				    		} else {
						    	for (TextComponent sentence: ((TextComposite) paragraph).getComponentList()){
						    		if (TextComponentType.SENTENCE.equals(componentType)){
						    		returnList.add(sentence);
						    		} else {
						    			for (TextComponent lexeme: ((TextComposite) sentence).getComponentList()){
								    		if (TextComponentType.LEXEME.equals(componentType)){
								    		returnList.add(lexeme);
								    		}
									    }
						    		}
							    }
				    		}
				    }
			}
		}
		return returnList;
	}
}
