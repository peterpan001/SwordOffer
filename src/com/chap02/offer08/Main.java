package com.chap02.offer08;
//斐波那契数列
public class Main {

	//递归实现
	public long fibonacci(int n){
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	//利用循环实现
	public long fibonacciByFor(int n){
		int result[] = {0, 1};
		if(n < 2){
			return result[n];
		}
		long fibNMiousOne = 0;
		long fibNMiousTwo = 1;
		long fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibNMiousOne + fibNMiousTwo;
			fibNMiousOne = fibNMiousTwo;
			fibNMiousTwo = fibN;
		}
		return fibN;
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		System.out.println(m1.fibonacci(0));
		System.out.println(m1.fibonacciByFor(0));
	}
	
	
}
