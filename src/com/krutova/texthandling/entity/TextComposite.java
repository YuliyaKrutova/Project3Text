package com.krutova.texthandling.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {
	
	private TextComponentType componentType;
	private ArrayList<TextComponent> componentList = new ArrayList<>();
	
	public TextComposite(TextComponentType componentType) {
		this.componentType = componentType;
	}

	public void addComponent(TextComponent component){
		componentList.add(component);
	}
	
	public void removeComponent(TextComponent component){
		componentList.remove(component);
	}

	@Override
	public String toString() {
		
		StringBuilder resultString = new StringBuilder();
		for (TextComponent comp: componentList){
				String compString=null;
				switch (componentType){
					case SYMBOL: {compString = comp.toString(); break;}
					case WORD: {compString = comp.toString();break;}
					case LEXEME: {compString = comp.toString();break;}
					case SENTENCE: {compString = " "+comp.toString();break;}
					case PARAGRAPH: {compString = " "+comp.toString();break;}
					case TEXT: {compString = "\n"+comp.toString();break;}
					default: {compString = comp.toString();break;}
				}
				resultString.append(compString);
			}
		return new String(resultString); //valueOf(resultString)
	}
	
	public TextComponentType getComponentType() {
		return componentType;
	}

	public ArrayList<TextComponent> getComponentList() {
		return componentList;
	}
}
