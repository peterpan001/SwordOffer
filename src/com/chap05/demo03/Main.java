package com.chap05.demo03;
/**
 * 连续子数组的最大和
 * @author Peter
 */
public class Main {

	boolean g_InvalidInput = false;
	public int findGreatestSumOfSubArray(int nums[]){
		int lens = nums.length;
		if(nums == null || lens == 0){
			g_InvalidInput = true;
			return 0;
		}
		g_InvalidInput = false;
		int nCurSum = 0;
		int nGreatestSum = 0x80000000;
		for (int i = 0; i < lens; i++) {
			if(nCurSum <= 0){
				nCurSum = nums[i];
			}else{
				nCurSum += nums[i];
			}
			if(nCurSum > nGreatestSum){
				nGreatestSum = nCurSum;
			}
		}
		return nGreatestSum;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		int nums[] = {1, -2, 3, 10, -4, 7, 2, -5};
		int subSum = m.findGreatestSumOfSubArray(nums);
		System.out.println(subSum);
	}
}
