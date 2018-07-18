package com.chap01.offer01;

import java.util.Scanner;

/**
 * 将字符串转换为整数 1:非数字字符 2:正负号 
 * @author Peter
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int length = str.length();
		int number = 0;
		char[] charArray = str.toCharArray();
		if (charArray[0] == '-') {
			for (int i = 1; i < length; i++) {
				if (charArray[i] > '9' || charArray[i] < '0') {
					System.out.println("输入的字符串中包含非数字字符");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(-number);
		} else if (charArray[0] == '+') {
			for (int i = 1; i < length; i++) {
				if (charArray[i] > '9' || charArray[i] < '0') {
					System.out.println("输入的字符串中包含非数字字符");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(number);
		} else {
			for (int i = 0; i < length; i++) {
				if (charArray[i] > '9' || charArray[i] < '0') {
					System.out.println("输入的字符串中包含非数字字符");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(number);
		}
	}

}
