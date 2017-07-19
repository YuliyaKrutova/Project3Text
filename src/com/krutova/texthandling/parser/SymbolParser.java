package com.krutova.texthandling.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krutova.texthandling.entity.Leaf;
import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;

public class SymbolParser {
	
	private final static String SYMBOL_REGEX = "."; //вынести отдельно все регулярные
	private Pattern pattern = Pattern.compile(SYMBOL_REGEX);
	
	public TextComponent parser(String textString, TextComposite composite){
		TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
		
		Matcher matcher = pattern.matcher(textString);
		while(matcher.find()){
			wordComposite.addComponent(new Leaf(matcher.group()));
		}
		composite.addComponent(wordComposite);
		return composite;
	} 
}
