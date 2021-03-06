package com.chap03.offer02;
//打印1到最大的n位数
public class Main1 {

	//打印1到最大的n位数的主方法
	public void printToMaxOfDigits(int n){
		if(n <= 0){
			System.out.println("输入的n没有意义");
			return;
		}
		char number[] = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		for (int i = 0; i < 10; ++i) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, 0);
		}	
	}
	
	//利用递归实现1到最大的n位数的全排列
	public void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
		if(index == n - 1){
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; ++i) {
			number[index + 1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, index + 1);
		}
	}
	
	//输出
	private void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			if(isBeginning0 && number[i]!='0'){
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		m1.printToMaxOfDigits(10);
	}
}
