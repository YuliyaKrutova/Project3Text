package com.krutova.texthandling.sort;

import java.util.ArrayList;
import java.util.HashMap;

import com.krutova.texthandling.action.TextAction;
import com.krutova.texthandling.entity.TextComponent;

public class SentenceSort {

	private HashMap<Integer,String> sortSentenceMap = new HashMap<Integer,String>();
	
	public HashMap<Integer,String> getSortSentenceList() {
		return sortSentenceMap;
	}

	public void sortSentenceList(ArrayList<TextComponent> listOfSentence){
		if (!listOfSentence.isEmpty()){
			for (TextComponent component: listOfSentence){
				sortSentenceMap.put(TextAction.wordCountInSentence(component.toString()), component.toString());
		    }
		}
	}
	
	public SentenceSort() {
		
	}

}
