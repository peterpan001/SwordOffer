package com.chap03.offer01;

//��ֵ�������η�
public class Main {

	// ָ��Ϊ���������
	public double powerWithExponent(double base, int exponent) {
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result *= base;
		}
		return result;
	}

	// ��ֵ�Ƚϵķ���
	public boolean equal(double num1, double num2) {
		if (Math.abs(num1 - num2) < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}

	// ��ֵ�������η�
	public double power(double base, int exponent) {
		double result = 0.0;
		// ���ȱȽϵ���Ϊ0,ָ��Ϊ������������������û������
		if (this.equal(base, 0.0) && exponent < 0) {
			try {
				throw new Exception("û������");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// exponent���������
		if (exponent == 0) { // exponentΪ0�����
			return 1.0;
		} else if (exponent < 0) { // exponentС��0�����
			result = this.powerWithExponent(1 / base, -exponent);
		} else if (exponent > 0) { // exponent����0�����
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
		double result = powerWithExponent1(base, exponent >> 1); //��������������˳���2
		result*=result;
		if((exponent & 0x1) == 1){ //��λ������������������������%�����ж�һ��������������ż��
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
