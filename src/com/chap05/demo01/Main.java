package com.chap05.demo01;
/**
 * 数组中出现次数超过一半的数字
 * @author Peter
 *
 */
public class Main {

	public int moreThanHalfNum(int nums[]){
		if(nums == null || nums.length == 0){ //如果数组为空或者数组长度为0都返回0
			return 0;
		}
		int len = nums.length;
		int start = 0;
		int middle = len >> 1;
		int end = len - 1;
		int index = partition(nums, start, end); //调用快速排序
		
		while(index!=middle){
			if(index > middle){ //如果它的下标大于n/2，那么中位数应该位于它的左边，接着在它的左边部分的数组中查找
				end = index - 1;
				index = partition(nums, start, end);
			}else{ //如果它的下标小于n/2，那么中位数应该位于它的右边，接着在它的右边部分的数组中查找
				start = index + 1; 
				index = partition(nums, start, end);
			}
		}
		int result = nums[middle];
		if(checkMoreThanHalf(nums, result)){ //判断一下result出现的次数是否超过result，超过返回结果否则返回0
			return result;
		}else{
			return 0;
		}
	}

	private int partition(int[] nums, int start, int end) {
		int privotKey = nums[start];
		while(start < end){
			while(start < end && privotKey <= nums[end]){
				--end;
			}
			swap(nums, start, end);//交换位置，使大于privotkey的值位于数组右边
			
			while(start < end && privotKey >= nums[start]){
				++start;
			}
			swap(nums, start, end);//交换位置，使小于privotkey的值位于数组左边
		}
		return start;
	}
	
	private void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
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
		Main m = new Main();
		int nums[] = {};
		int num = m.moreThanHalfNum(nums);
		System.out.println(num);
	}
	
}
