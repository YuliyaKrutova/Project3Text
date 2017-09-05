package com.krutova.texthandling.parser;

import com.krutova.texthandling.entity.TextComposite;

public abstract class AbstractParser {
	public static final String SYMBOL_REGEX = ".";
	public static final String WORD_REGEX = "([A-z])+"; 
	public static final String PUNKT_REGEX = "\\p{Punct}";
	public static final String LEXEME_REGEX = "([A-z])+\\p{Punct}?";
	public static final String SENTENCE_REGEX = ".*?(?:[.!:]\\s?|\\?\\s)";
	public static final String PARAGRAPH_REGEX = "(\\t|\\s)+.+(\r\n)?";
	public abstract TextComposite parser(String textString, TextComposite compositeText);
}
