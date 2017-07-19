package com.krutova.texthandling.entity; 

public class Leaf implements TextComponent {
	private String string;  //private Character string; 
	
	public Leaf(String string) {
		this.string = string;
	}
	
	public Leaf(char symbol) {
		this.string = String.valueOf(symbol) ;
	}

	@Override
	public String toString() {
		return string;
	}

	
	
}
