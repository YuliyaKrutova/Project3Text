package com.krutova.texthandling.main;

import java.util.ArrayList;

import com.krutova.texthandling.entity.CharacterLeaf;
import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;
import com.krutova.texthandling.filemanager.ReadTextFromFile;
import com.krutova.texthandling.parser.ParserWordToCharacter;
import com.krutova.texthandling.parser.ParserSentenceToLexeme;
import com.krutova.texthandling.parser.ParserTextToParagraph;
import com.krutova.texthandling.parser.ParserLexemeToWordPunct;
import com.krutova.texthandling.parser.ParserParagraphToSentence;
import com.krutova.texthandling.textexception.TextException;


public class TextMain {
	
	private final static String FILE_NAME = "data\\Text.txt";
	
	public static void main(String[] args){

		String textString=null;
		try {
			textString = ReadTextFromFile.readTextFromFile(FILE_NAME);
		} catch (TextException e) {
			e.printStackTrace();
		}
		
		ParserWordToCharacter par = new ParserWordToCharacter();
		ParserLexemeToWordPunct par2 = new ParserLexemeToWordPunct();
		ParserSentenceToLexeme par3 = new ParserSentenceToLexeme();
		ParserParagraphToSentence par4 = new ParserParagraphToSentence();
		ParserTextToParagraph par5 = new ParserTextToParagraph();
		TextComposite comp = new TextComposite(TextComponentType.WORD);
		par5.parser(textString, comp);
		//par5.parser("Qqqqq wwwww rrrrr, rrrr. Sssss eeeee fffff!"/*textString*/, comp);
		//par4.parser("Bsdfg qwerty, qqqqqqq. Aasdasdasd adasd!", comp);
		//par3.parser("asdfg qwerty,", comp);
		//par2.parser("qwerty,", comp);
		//par.parser("qwerty", comp);

		System.out.println(comp.toString());

	
		TextComposite ar1 = (TextComposite) comp.getComponentList().get(0);
		TextComposite ar2 = (TextComposite) ar1.getComponentList().get(1);
		
		System.out.println(ar2.getComponentList().toString());
		System.out.println(ar2.getComponentType());
		
		System.out.println("***************************************");
		
		
		

		
		
		
		
	}
}
