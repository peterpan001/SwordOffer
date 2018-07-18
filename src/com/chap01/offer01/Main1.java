package com.chap01.offer01;

import java.util.Scanner;

/**
 * 字符串转整形源码
 */
public class Main1 {

	/**
	 * 将字符串转化为整形
	 * @param s
	 * @return
	 * @throws NumberFormatException
	 */
	public static int parseInt(String s) throws NumberFormatException {
		return parseInt(s, 10);
	}
	
	/**
	 * 将字符串转化为整形，其中radix代表基数，即代表你输入的是几进制的字符串。
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
		
		//判断是否为空
		if (s == null) {
			throw new NumberFormatException("null");
		}
		
		//判断不能小于2进制
		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " less than Character.MIN_RADIX");
		}

		//判断不能大于36进制 0-9，a-z一共36进制
		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;  //-0x7fffffff即：-2147483647 
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
