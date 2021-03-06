package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class TextParser extends AbstractParser {

	private Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEX);
	private ParagraphParser nextParser = new ParagraphParser();
	
	public TextComposite parser(String textString, TextComposite compositeText){
		TextComposite compositeParagraph = new TextComposite(TextComponentType.PARAGRAPH);
		Matcher paragraphMatcher = paragraphPattern.matcher(textString);
		
		while(paragraphMatcher.find()){
			compositeParagraph=nextParser.parser(paragraphMatcher.group(), compositeParagraph);
			
		} 
		compositeText.addComponent(compositeParagraph);
		return compositeText;
	} 
}
