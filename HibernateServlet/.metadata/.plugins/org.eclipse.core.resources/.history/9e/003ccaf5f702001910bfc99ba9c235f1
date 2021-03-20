package com.revature.practice;

public class BallBouce {
	
	public static void main(String[] args) {
		System.out.println(bouncingBall(3, 0.66, 1.5));
		System.out.println(findMissingLetter(new char[] { 'a','b','c','d','f' }));
	}
	
	public static int bouncingBall(double h, double bounce, double window) {
	    // your code
      
      int count = 0;
      while(h>window) {
        h= h*bounce;
        count++;
      
      }
      if(count==0) {
        return -1;
      } else {
      
        return count;
      }
	}
	
	
	public static char findMissingLetter(char[] array)
	  {
	  
	    char[] lowerChar = {'a','b','c','d','e','f','g','h','i','g','k','l','m','n','o','p',
	    'q','r','s','t','u','v','w','x','y','z'};
	    
	    char result ='-';
	    
	    for(int i = 0; i < array.length; i++) {
	    
	      if(array[i] != lowerChar[i]) {
	        
	        result = lowerChar[i];
	      
	      }
	    }
	    return result;
	    
	  }

}
