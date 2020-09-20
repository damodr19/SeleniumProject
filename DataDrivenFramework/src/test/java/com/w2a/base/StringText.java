package com.w2a.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "Today is my interview and my interview today went well";
		
		List <String> duplicate = new ArrayList<String>();

		String word [] = text.toUpperCase().split(" ");

		Set<String>  textWith = new HashSet<String>();

		for( String t1: word)
		{
		
			 if (!textWith .add(t1) )
			 {
				 duplicate.add(t1);
			 }
		
		}
		System.out.println(textWith);
		
		System.out.println("Dublicate" + duplicate);

	}

}
