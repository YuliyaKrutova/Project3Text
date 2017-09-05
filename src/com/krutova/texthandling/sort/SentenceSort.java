package com.krutova.texthandling.sort;

import java.util.ArrayList;
import java.util.HashMap;

import com.krutova.texthandling.action.TextAction;
import com.krutova.texthandling.entity.TextComponent;

public class SentenceSort {

	private HashMap<Integer,String> sortSentenceList = new HashMap<Integer,String>();
	
	public HashMap<Integer,String> getSortSentenceList() {
		return sortSentenceList;
	}

	public void sortSentenceList(ArrayList<TextComponent> listOfSentence){
		if (!listOfSentence.isEmpty()){
			for (TextComponent component: listOfSentence){
				sortSentenceList.put(TextAction.wordCountInSentence(component.toString()), component.toString());
		    }
		}
	}
	
	public SentenceSort() {
		
	}

}
