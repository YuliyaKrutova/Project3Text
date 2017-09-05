package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class SentenceParser extends AbstractParser {
	
	private Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);
	private LexemeParser nextParser = new LexemeParser();
	
	public TextComposite parser(String textString, TextComposite compositeSentense){
		TextComposite compositeLexeme = new TextComposite(TextComponentType.LEXEME);
		Matcher lexemeMatcher = lexemePattern.matcher(textString);
		
		while(lexemeMatcher.find()){
			compositeLexeme=nextParser.parser(lexemeMatcher.group(), compositeLexeme);
			
		} 
		compositeSentense.addComponent(compositeLexeme);
		return compositeSentense;
	} 
}
