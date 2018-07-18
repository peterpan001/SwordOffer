package com.chap03.offer01;

//数值的整数次方
public class Main {

	// 指数为正数的情况
	public double powerWithExponent(double base, int exponent) {
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result *= base;
		}
		return result;
	}

	// 数值比较的方法
	public boolean equal(double num1, double num2) {
		if (Math.abs(num1 - num2) < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}

	// 数值的整数次方
	public double power(double base, int exponent) {
		double result = 0.0;
		// 首先比较底数为0,指数为负数的情况，这种情况没有意义
		if (this.equal(base, 0.0) && exponent < 0) {
			try {
				throw new Exception("没有意义");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// exponent的三种情况
		if (exponent == 0) { // exponent为0的情况
			return 1.0;
		} else if (exponent < 0) { // exponent小于0的情况
			result = this.powerWithExponent(1 / base, -exponent);
		} else if (exponent > 0) { // exponent大于0的情况
			result = this.powerWithExponent(base, exponent);
		}
		return result;
	}

	public double powerWithExponent1(double base, int exponent){
		if(exponent == 0){
			return 1;
		}
		if(exponent == 1){
			return base;
		}
		double result = powerWithExponent1(base, exponent >> 1); //用右移运算代替了除以2
		result*=result;
		if((exponent & 0x1) == 1){ //用位与运算符代替了求余运算符（%）来判断一个数是奇数还是偶数
			result*=base;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Main m1 = new Main();
		System.out.println(m1.powerWithExponent(2, 2));
		System.out.println(m1.powerWithExponent1(2, 2));
		System.out.println(m1.power(0, 3));
		System.out.println(m1.power(-2, 3));
		System.out.println(m1.power(2, -3));
		System.out.println(m1.power(2, 0));
	}
}
