package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class ParagraphParser extends AbstractParser {
	
	private Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
	private SentenceParser nextParser = new SentenceParser();
	
	public TextComposite parser(String textString, TextComposite compositeParagraph){
		TextComposite compositeSentence = new TextComposite(TextComponentType.SENTENCE);
		Matcher sentenceMatcher = sentencePattern.matcher(textString);
		
		while(sentenceMatcher.find()){
			compositeSentence=nextParser.parser(sentenceMatcher.group(), compositeSentence);
			
		} 
		compositeParagraph.addComponent(compositeSentence);
		return compositeParagraph;
	} 
}
