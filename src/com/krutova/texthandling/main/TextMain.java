package com.krutova.texthandling.main;

import com.krutova.texthandling.entity.Leaf;
import com.krutova.texthandling.entity.TextComponent;
import com.krutova.texthandling.entity.TextComponentType;
import com.krutova.texthandling.entity.TextComposite;
import com.krutova.texthandling.filemanager.ReadTextFromFile;
import com.krutova.texthandling.parser.LexemeParser;
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
		
		
		TextComponent component1 = new Leaf("я");
		TextComponent component2 = new Leaf("з");
		TextComponent component3 = new Leaf('д');
		TextComponent component4 = new Leaf('е');
		TextComponent component5 = new Leaf('с');
		TextComponent component6 = new Leaf('ь');
		
		
		TextComponent component = new Leaf(textString);
		
		TextComposite composite1 = new TextComposite(TextComponentType.LEXEME);
		TextComposite composite2 = new TextComposite(TextComponentType.LEXEME);
		TextComposite composite3 = new TextComposite(TextComponentType.SENTENCE);
		
		TextComposite composite = new TextComposite(TextComponentType.TEXT);
		
		composite1.addComponent(component1);
		composite2.addComponent(component2);
		composite2.addComponent(component3);
		composite2.addComponent(component4);
		composite2.addComponent(component5);
		composite2.addComponent(component6);
		composite3.addComponent(composite1);
		composite3.addComponent(composite2);
		
		composite.addComponent(component);
		
		System.out.println("composite1="+composite1.toString());
		System.out.println("composite2="+composite2.toString());
		
		System.out.println("composite3="+composite3.toString());
		System.out.println("--------------------------------");
		//System.out.println("composite:\n"+composite.toString());
		
		TextComposite composite5 = new TextComposite(TextComponentType.SYMBOL);
//		WordParser word = new WordParser();
//		word.parser("qwerty!", composite5);
//		System.out.println("--------------------------------");
//		System.out.println("composite5="+composite5.toString());
		
		LexemeParser lexeme = new LexemeParser();
		lexeme.parser("aaaaa bbbbb!", composite5);
		System.out.println("--------------------------------");
		System.out.println("composite5="+composite5.toString());
		System.out.println("--------------------------------");
		
		System.out.println("");
		
		System.out.println("--------------------------------");
		

		
		
		
		
	}
}
