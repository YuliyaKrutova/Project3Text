package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class LexemeParser {
	private final static String LEXEME_REGEX = "([A-z])+\\p{Punct}?"; //вынести отдельно все регулярные
	private Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);
	private WordParser nextParser = new WordParser();
	
	public TextComponent parser(String textString, TextComposite composite){
		TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
		Matcher sentenceMatcher = lexemePattern.matcher(textString);
		
		while(sentenceMatcher.find()){
			nextParser.parser(sentenceMatcher.group(), sentenceComposite);
		} 
		composite.addComponent(sentenceComposite);
		return composite;
	} 
}
