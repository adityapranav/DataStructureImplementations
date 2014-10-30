package com.ds.DynamicProgramming;

public class FibonacciNumber {
	
	public static int fibNumRecursion(int n)
	{
		if( n == 1 || n == 2 )
			return 1;
		return fibNumRecursion(n-1)+fibNumRecursion(n-2);
	}
	public static int fibNumMemoization(int n)
	{
		int[] out = new int[n+1];
		return fibNumMemoization(n,out);
	}
	private static int fibNumMemoization(int n,int[] out)
	{
		
		if( n == 1 || n==2 )
			return 1;
		
		if( out[n] != 0)
			return out[n];
		
		out[n] = fibNumMemoization(n-1,out) + fibNumMemoization(n-2,out);
		    
		return out[n];
	}
	public static int fibNumDP(int n)
	{
		int[] out = new int[n+1];
		return fibNumDP(n,out);
	}
	private static int fibNumDP(int n,int []out)
	{
		out[0] = 1;
		out[1] = 1;
		for(int i=2;i<= n-1; ++i)
		{
			out[i]=out[i-1]+out[i-2];
		}
		return out[n-1];
	}
}
