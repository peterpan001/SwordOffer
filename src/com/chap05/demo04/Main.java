package com.chap05.demo04;
/**
 * ��1��n������1���ֵĴ���
 * @author Peter
 *
 */
public class Main {
	
	/**
	 * ��1��n�е�ÿ��������1���ֵ��ܹ��ж��ٴ�
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
	 * ��ÿ��������1���ֵĴ���
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
