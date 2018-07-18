package com.chap03.offer04;

public class Main1 {

	public boolean isEven(int num){
		if((num & 0x1) == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isDivideBy3(int num){
		if(num % 3 == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isNonnegativeNumber(int num){
		if(num >= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void reorder(int []number){
		int len = number.length;
		if(number == null || len == 0){
			return;
		}
		int begin = 0;
		int end = len -1;
		while(begin < end){
			while((begin < end) /*&& 方法*/){
				++begin;
			}
			while((begin < end)/* && 方法*/){
				--end;
			}
			if(begin < end){
				int temp = number[begin];
				number[begin] = number[end];
				number[end] = temp;
			}
		}
	}
}
