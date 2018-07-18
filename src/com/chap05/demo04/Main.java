package com.chap05.demo04;
/**
 * 从1到n整数中1出现的次数
 * @author Peter
 *
 */
public class Main {
	
	/**
	 * 求1到n中的每个整数中1出现的总共有多少次
	 */
	public static int numberOf1Between1AndN(int n){
		int count = 0;
		if(n < 0){
			return 0;
		}
		for (int i = 1; i <= n; i++) {
			count += numberOf1(i);
		}
		return count;
	}

	/**
	 * 求每个整数中1出现的次数
	 * @param n
	 * @return
	 */
	private static int numberOf1(int n) {
		int count = 0;
		while(n>0){
			if(n % 10 == 1){
				++count;
			}
			n = n / 10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int counts = Main.numberOf1Between1AndN(-12);
		System.out.println(counts);
	}
}
