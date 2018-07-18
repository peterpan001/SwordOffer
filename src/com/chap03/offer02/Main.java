package com.chap03.offer02;
//��ӡ1������nλ��
public class Main {
	
	/*
	public void printToMaxOfNDigits(int n){
		long number = 1;
		int i = 0;
		while(i < n){
			number *= 10;
			++i;
		}
		for (long j = 1; j < number; j++) {
			System.out.print(j + " ");
			if(j%5 == 0){
				System.out.println();
			}
		}
	}
	*/
	/*
	public void printToMaxOfDigits(int n){
		if(n <= 0){
			return ;
		}
		char number[] = new char[n];
		//��ÿһ���ַ�����Ϊ0
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		} 
		while(!increment(number)){ //���ַ���+1����������������ֱ���˳���
			printNumber(number); //��ӡ�ַ�������
		}
	}
	
	//��ӡ
	private void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			if(isBeginning0 && number[i] != '0'){
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	//�������ж��Ƿ���������ֱ���˳�
	private boolean increment(char[] number) {
		boolean isOverflow = false; //�����ʶ
		int nTakeOver = 0; //��λ
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; --i) {
			int nSum = number[i] - '0' + nTakeOver;
			if(i == nLength-1){ //���λ+1����
				++nSum; 
			}
			if(nSum >= 10){
				if(i == 0){
					isOverflow = true;
				}else{
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				number[i] = (char) ('0' + nSum);
				break;
			}
			
		}
		return isOverflow;
	}

	public static void main(String[] args) {
		Main m1 = new Main();
		m1.printToMaxOfDigits(3);
	}*/
	
	//��ӡ1������nλ��
	public void printToMaxOfDigits(int n){
		if(n <= 0){
			System.out.println("�����nû������");
			return;
		}
		//�����ַ�����,�������һ������
		char number[] = new char[n];
		for (int i = 0; i < number.length; ++i) { //���ַ�0���г�ʼ��
			number[i] = '0';
		}
		while(!incrementNumber(number)){ //��������Լӣ�ֱ�������˳�
			printNumber(number); //��ӡ����
		}
	}
	
	//��ӡ����
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

	//�Լ�
	private boolean incrementNumber(char[] number) {
		boolean isOverflow = false; //�ж��Ƿ����
		int nTakeOver = 0; //�ж��Ƿ��λ
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0 ; --i) {
			int nSum = number[i] - '0' + nTakeOver; //ȡ����iλ���ַ�ת��Ϊ���� +��λ��
			if(i == nLength - 1){ //ĩβ�Լ�1
				++nSum;
			}
			if(nSum >= 10){
				if(i == 0){
					isOverflow = true;
				}else{
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				number[i] = (char) (nSum + '0');
				break;
			}
		}
		return isOverflow;
	}


	public static void main(String[] args) {
		Main m1 = new Main();
		m1.printToMaxOfDigits(-10);
		m1.printToMaxOfDigits(0);
		m1.printToMaxOfDigits(10);
		m1.printToMaxOfDigits(100);
	}
	
	
}
