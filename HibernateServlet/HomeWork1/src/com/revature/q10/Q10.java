package com.revature.q10;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q10 {
	
	String splitOfWord;
	String[] stringtoBeSplit;
	int numberToSquareRoot;
	
	Q10() {
		super();
		
		//Setting values of non static variables to be used by object
				this.numberToSquareRoot = 5;
				this.splitOfWord = "I am learning Core Java";
	}
	
	public String switchDemo(String switchCase) {
		
		switch(switchCase) {
		
		case "root": 
			//System.out.println(Math.sqrt(numberToSquareRoot));
			return new Double(Math.sqrt(numberToSquareRoot)).toString();
		case "date":
			return new Date().toString();
		case "split":
			this.stringtoBeSplit = this.splitOfWord.split(" ");
			return Arrays.toString(stringtoBeSplit);
		default:
			return "Wrong case";
		}
		
	
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("ENter case:");
		
		String switchCase = scan.nextLine();
		
		Q10 q = new Q10();
		System.out.println(q.switchDemo(switchCase));
		
	}

}
