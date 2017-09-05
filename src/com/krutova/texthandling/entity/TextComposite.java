package com.krutova.texthandling.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {
	
	private TextComponentType componentType;

	private ArrayList<TextComponent> componentList = new ArrayList<>();
	
	public TextComposite(TextComponentType componentType) {
		this.componentType = componentType;
	}
	
	public TextComposite() {
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
			 switch (componentType){
			 case PARAGRAPH:{
				 resultString.append("    ");
				 resultString.append(comp.toString());
				 resultString.append("\n");
				 break;
			 	}
			 case LEXEME:{
				 if (!comp.toString().matches("\\p{Punct}")){
				 resultString.append(" ");
				 }
				 resultString.append(comp.toString());
				 break;
			 	}
			 default: resultString.append(comp.toString());
			 }
		 }
		
		return resultString.toString();
	}

	public TextComponentType getComponentType() {
		return componentType;
	}

	public ArrayList<TextComponent> getComponentList() {
		return componentList;
	}
}
