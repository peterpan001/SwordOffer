package com.chap01.offer01;

import java.util.Scanner;

/**
 * ���ַ���ת��Ϊ���� 1:�������ַ� 2:������ 
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
					System.out.println("������ַ����а����������ַ�");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(-number);
		} else if (charArray[0] == '+') {
			for (int i = 1; i < length; i++) {
				if (charArray[i] > '9' || charArray[i] < '0') {
					System.out.println("������ַ����а����������ַ�");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(number);
		} else {
			for (int i = 0; i < length; i++) {
				if (charArray[i] > '9' || charArray[i] < '0') {
					System.out.println("������ַ����а����������ַ�");
					return;
				} else {
					number = number * 10 + charArray[i] - '0';
				}
			}
			System.out.println(number);
		}
	}

}
