package com.revature.fibonacci;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Find fibonacci numbers
 * @author thienle
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for(int i = 0; i <= 25; i++) {
//			System.out.println(fib(i));
//		}
		
		System.out.println(Arrays.toString(fib2(5)));
		
	
			System.out.println(fib(5));
		
		

	}
	
	public static int[] fib2(int num) {
		
		
		int[] feb;
		
		if(num>=2) {
			feb = new int[num];
			
			feb[0] = 0;
			feb[1] = 1;
		for (int i = 2; i < num; i++) {
			
			
			feb[i] = feb[i-1] + feb[i-2];
			
		}
		return feb;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Recursive call to find fibonacci number
	 * @param num
	 * @return
	 */
	public static long fib(int num) {
		
		if(num==0 || num == 1) return num;
		return fib(num-1) + fib(num-2);
		
	}
	
	

}
