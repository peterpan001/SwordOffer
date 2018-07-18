package com.chap02.offer11;
//二进制中1的个数
public class Main {

	public int numberOf1(int n){
		int count = 0;
		while(n!=0){
			if((n&1) != 0){
				++count;
			}
			n = n >> 1;
		}
		return count;
	}
	
	public int numberOfs1(int n){
		int count = 0;
		int flag = 1;
		while(flag!=0){
			if((n&flag) != 0){
				++count;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public int numbersOf1(int n){
		int count = 0;
		while(n != 0){
			++count;
			n = (n-1) & n;
		}
		return count;
	}
	
	public boolean judgeNum2Square(int num){
		if((num & (num-1)) != 0){
			return false;
		}else{
			return true;
		}
	}
	
	public int changeCount(int n, int m){
		int count = 0;
		int x = n^m;
		while(x!=0){
			++count;
			x = (x-1) & x;
		}
		return count;
	}
	
	public static void main(String[] args) {

		Main m1 = new Main();
		System.out.println(m1.numberOf1(1));
		System.out.println(m1.numberOfs1(-1));
		System.out.println(m1.numbersOf1(-1));
		System.out.println(m1.judgeNum2Square(3));
		System.out.println(m1.changeCount(10, 13));
	}
}
