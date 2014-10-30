package com.ds.DynamicProgramming;

public class DPTestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    
			System.out.println("The value is "+FibonacciNumber.fibNumRecursion(9));
			System.out.println("The value is "+FibonacciNumber.fibNumMemoization(9));
			System.out.println("The value is "+FibonacciNumber.fibNumDP(9));
	}

}
