package com.chap05.demo02;

import java.util.ArrayList;
/**
 * 最小的k个数
 * @author Peter
 *
 */
public class Main {

	public ArrayList<Integer> getLeastNumbers(int nums[], int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int lens = nums.length;
		if(nums == null || lens == 0 || k > lens || k <= 0){
			return list;
		}
		int start = 0;
		int end = lens - 1;
		int index = partition(nums, start, end);
		while(index != k-1){
			if(index > k-1){
				end = index - 1;
				index = partition(nums, start, end);
			}else{
				start = index + 1;
				index = partition(nums, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			list.add(nums[i]);
		}
		return list;
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
	
	public static void main(String[] args) {
		int nums[] = {4, 5, 1, 6, 2, 7, 3, 8};
		Main m = new Main();
		ArrayList<Integer> list = m.getLeastNumbers(nums, 4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
