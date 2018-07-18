package com.chap05.demo01;

public class Main1 {

	public int moreThanHalfNum(int nums[]){
		int lens = nums.length;
		if(nums==null || lens == 0){
			return 0;
		}
		int result = nums[0];
		int times = 1;
		for (int i = 1; i < lens; ++i) {
			if(times==0){
				result = nums[i];
				times = 1;
			}else if(nums[i] == result){
				++times;
			}else{
				--times;
			}
		}
		if(checkMoreThanHalf(nums, result)){ //判断一下result出现的次数是否超过result，超过返回结果否则返回0
			return result;
		}else{
			return 0;
		}
	}
	
	private boolean checkMoreThanHalf(int nums[], int result){
		int times = 0;
		int lens = nums.length;
		for (int i = 0; i < lens; i++) {
			if(result == nums[i]){
				++times;
			}
		}
		if(times * 2 > lens){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Main1 m1 = new Main1();
		int nums[] = {1, 2, 3, 2, 2, 3, 2, 4, 2};
		int num = m1.moreThanHalfNum(nums);
		System.out.println(num);
	}
	
}
