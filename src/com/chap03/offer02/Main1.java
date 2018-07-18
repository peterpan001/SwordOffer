package com.chap03.offer02;
//��ӡ1������nλ��
public class Main1 {

	//��ӡ1������nλ����������
	public void printToMaxOfDigits(int n){
		if(n <= 0){
			System.out.println("�����nû������");
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
	
	//���õݹ�ʵ��1������nλ����ȫ����
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
	
	//���
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
