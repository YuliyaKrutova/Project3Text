package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class WordParser {
	private final static String WORD_REGEX = "([A-z])+"; //вынести отдельно все регулярные
	private final static String PUNKT_REGEX = "\\p{Punct}"; //вынести отдельно все регулярные
	private Pattern wordPattern = Pattern.compile(WORD_REGEX);
	private Pattern punctPattern = Pattern.compile(PUNKT_REGEX);
	private SymbolParser nextParser = new SymbolParser();
	
	public TextComponent parser(String textString, TextComposite composite){
		TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
		Matcher wordMatcher = wordPattern.matcher(textString);
		Matcher punctMatcher = punctPattern.matcher(textString);
		
		if(wordMatcher.find()){
			nextParser.parser(wordMatcher.group(), lexemeComposite);
		} 
		if (punctMatcher.find()){
			nextParser.parser(punctMatcher.group(), lexemeComposite);
		}
		composite.addComponent(lexemeComposite);
		return composite;
	} 
}
