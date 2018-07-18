package com.chap03.offer02;
//打印1到最大的n位数
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
		//把每一个字符设置为0
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		} 
		while(!increment(number)){ //做字符串+1自增操作，如果溢出直接退出。
			printNumber(number); //打印字符串数字
		}
	}
	
	//打印
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
	//自增，判断是否溢出，溢出直接退出
	private boolean increment(char[] number) {
		boolean isOverflow = false; //溢出标识
		int nTakeOver = 0; //进位
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; --i) {
			int nSum = number[i] - '0' + nTakeOver;
			if(i == nLength-1){ //最低位+1操作
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
	
	//打印1到最大的n位数
	public void printToMaxOfDigits(int n){
		if(n <= 0){
			System.out.println("输入的n没有意义");
			return;
		}
		//声明字符数组,用来存放一个大数
		char number[] = new char[n];
		for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
			number[i] = '0';
		}
		while(!incrementNumber(number)){ //如果大数自加，直到自溢退出
			printNumber(number); //打印大数
		}
	}
	
	//打印数字
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

	//自加
	private boolean incrementNumber(char[] number) {
		boolean isOverflow = false; //判断是否溢出
		int nTakeOver = 0; //判断是否进位
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0 ; --i) {
			int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
			if(i == nLength - 1){ //末尾自加1
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
