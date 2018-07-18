package com.chap01.offer01;

import java.util.Scanner;

/**
 * �ַ���ת����Դ��
 */
public class Main1 {

	/**
	 * ���ַ���ת��Ϊ����
	 * @param s
	 * @return
	 * @throws NumberFormatException
	 */
	public static int parseInt(String s) throws NumberFormatException {
		return parseInt(s, 10);
	}
	
	/**
	 * ���ַ���ת��Ϊ���Σ�����radix�����������������������Ǽ����Ƶ��ַ�����
	 * @param s
	 * @param radix
	 * @return
	 * @throws NumberFormatException
	 */
	public static int parseInt(String s, int radix)
			throws NumberFormatException {
		/*
		 * WARNING: This method may be invoked early during VM initialization
		 * before IntegerCache is initialized. Care must be taken to not use the
		 * valueOf method.
		 */
		
		//�ж��Ƿ�Ϊ��
		if (s == null) {
			throw new NumberFormatException("null");
		}
		
		//�жϲ���С��2����
		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " less than Character.MIN_RADIX");
		}

		//�жϲ��ܴ���36���� 0-9��a-zһ��36����
		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;  //-0x7fffffff����-2147483647 
		int multmin;
		int digit;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;  //0x80000000
				} else if (firstChar != '+')
					throw NumberFormatException.forInputString(s);

				if (len == 1) // Cannot have lone "+" or "-"
					throw NumberFormatException.forInputString(s);
				i++;
			}
			multmin = limit / radix;  //-214748364
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					throw NumberFormatException.forInputString(s);
				}
				if (result < multmin) {
					throw NumberFormatException.forInputString(s);
				}
				result *= radix;
				if (result < limit + digit) {
					throw NumberFormatException.forInputString(s);
				}
				result -= digit;
			}
		} else {
			throw NumberFormatException.forInputString(s);
		}

		return negative ? result : -result;
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int num = parseInt(str);
		System.out.println(num);
	}
}
