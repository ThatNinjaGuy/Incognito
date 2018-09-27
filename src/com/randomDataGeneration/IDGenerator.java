package com.randomDataGeneration;

import java.util.List;
import java.util.Random;

import com.io.ReadFile;

public class IDGenerator {

	public static int conNumber =1;

	public String generateIDFromName(String name) {
		String[] partOfNames = name.split(" ");
		String nextConNumber = Integer.toString(conNumber);
		int n = nextConNumber.length();
		String zero = new String(new char[5-n]).replace("\0", "0");
		nextConNumber = zero + nextConNumber;
		//System.out.println(nextConNumber);

		String result = null;
		if(partOfNames.length == 1) result = Character.toString(partOfNames[0].charAt(0))
				+Character.toString(partOfNames[0].charAt(0))
				+nextConNumber;
		else result = Character.toString(partOfNames[0].charAt(0))
				+Character.toString(partOfNames[partOfNames.length -1].charAt(0))
				+nextConNumber;
		//System.out.println(result);
		conNumber++;
		return result;
	}
}