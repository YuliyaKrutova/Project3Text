package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.CharacterLeaf;
import com.krutova.texthandling.entity.TextComposite;

public class WordParser extends AbstractParser {
	
	private Pattern pattern = Pattern.compile(SYMBOL_REGEX);
	
	public TextComposite parser(String textString, TextComposite composite){
		Matcher matcher = pattern.matcher(textString);
		while(matcher.find()){
			composite.addComponent(new CharacterLeaf(matcher.group().charAt(0)));
		}
		return composite;
	} 
}
