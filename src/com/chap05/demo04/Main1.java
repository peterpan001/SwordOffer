package com.chap05.demo04;
/**
 * ��1��n������1���ֵĴ���
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
			high = n / (int)Math.pow(10, i); //��ȡ��iλ�ĸ�λ
			temp = n % (int)Math.pow(10, i); //
			low = temp / (int)Math.pow(10, i-1); //��ȡ��iλ
			
		}
		return 0;
	}
}
