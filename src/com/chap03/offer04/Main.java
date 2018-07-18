package com.chap03.offer04;
//调整数组顺序使奇数位于偶数前面
public class Main {

	public void reorderOddEven(int []number){
		if(number == null && number.length == 0){
			return;
		}
		int len = number.length; //存储数组长度
		int count = 0; //控制数组遍历的循环次数
		for (int i = 0; i < len && count < len; ++i) { //
			++count;
			int temp = number[i];
			if((temp & 0x1) == 0){ //如果为偶数，移动数组，将数放入数组末尾，并使i在i-1的位置，重新开始判断
				for (int j = i; j < len-1; ++j) {
					number[j] = number[j+1];
				}
				number[len-1] = temp;
				--i;
			}
		}
	}
	public void reorderOddEven2(int []number){
		if(number == null && number.length == 0){
			return;
		}
		for (int i = 0, j = 0; i < number.length; ++i) {
			if((number[i] & 0x1) != 0){
				int temp = number[i];
				number[i] = number[j];
				number[j] = temp;
				++j;
			}
		}
	}
	public void reorderOddEven1(int []number){
		int len = number.length;
		if(number == null || len == 0){
			return;
		}
		int begin = 0;
		int end = len -1;
		while(begin < end){
			while((begin < end) && (number[begin] & 0x1) != 0){
				++begin;
			}
			while((begin < end) && (number[end] & 0x1) == 0){
				--end;
			}
			if(begin < end){
				int temp = number[begin];
				number[begin] = number[end];
				number[end] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		int number[] = {1, 2, 2, 3, 4, 6, 7};
		m1.reorderOddEven1(number);
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}
}
