package com.chap05.demo04;
/**
 * 从1到n整数中1出现的次数
 * @author Peter
 * 
 */
public class Main1 {

	public int numberOf1Between1AndN(int n, int x){
		if(n < 0 || x < 0 || x > 9){
			return 0;
		}
		int curr, low, temp, high = n, i = 1, total = 0;
		while(high!=0){
			high = n / (int)Math.pow(10, i); //获取第i位的高位
			temp = n % (int)Math.pow(10, i); //
			low = temp / (int)Math.pow(10, i-1); //获取第i位
			
		}
		return 0;
	}
}
