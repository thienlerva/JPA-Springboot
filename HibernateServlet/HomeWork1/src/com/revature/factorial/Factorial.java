package com.revature.factorial;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * compute N factorial
 * @author thienle
 *
 */
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(factorial2(8));
		

	}
	
	/*
	 * Recursive method to compute N factorial
	 */
	public static int factorial(int num) {
		
	
		if(num == 0) return 1;
		return  num * factorial(num - 1);
		
		
	}
	
	public static int factorial2(int num) {
		
		
		int result = 1;
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i = num-1; i >= 0; i--) {
			result = result * arr[i];
		}
		return result;
	}

}
