package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class ParserLexemeToWordPunct {
	private final static String WORD_REGEX = "([A-z])+"; //вынести отдельно все регулярные
	private final static String PUNKT_REGEX = "\\p{Punct}"; //вынести отдельно все регулярные
	private Pattern wordPattern = Pattern.compile(WORD_REGEX);
	private Pattern punctPattern = Pattern.compile(PUNKT_REGEX);
	private ParserWordToCharacter nextParser = new ParserWordToCharacter();
	
	public TextComposite parser(String textString, TextComposite compositeLexeme){
		TextComposite compositeWord = new TextComposite(TextComponentType.WORD);
		TextComposite compositePunct = new TextComposite(TextComponentType.SYMBOL);
		Matcher wordMatcher = wordPattern.matcher(textString);
		Matcher punctMatcher = punctPattern.matcher(textString);
		
		if(wordMatcher.find()){
			compositeWord= nextParser.parser(wordMatcher.group(), compositeWord);
		} 
		if (punctMatcher.find()){
			compositePunct=nextParser.parser(punctMatcher.group(), compositePunct);
		}
		compositeLexeme.addComponent(compositeWord);
		compositeLexeme.addComponent(compositePunct);
		return compositeLexeme;
	} 
}
