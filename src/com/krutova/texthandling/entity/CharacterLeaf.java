package com.krutova.texthandling.entity; 

public class CharacterLeaf implements TextComponent {
	
	private Character symbol;  //private Character string; 
	
	public CharacterLeaf(Character symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol.toString();
	}


}
