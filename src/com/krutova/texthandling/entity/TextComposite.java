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
		return "componentList=" + componentList;
	}

	public TextComponentType getComponentType() {
		return componentType;
	}

	public ArrayList<TextComponent> getComponentList() {
		return componentList;
	}
}
