package com.chap05.demo03;
/**
 * 连续子数组的最大和
 * @author Peter
 *
 */
public class Main1 {

	boolean g_InvalidInput = false;
	public int findGreatestSumOfSubArray(int nums[]){
		if(nums==null || nums.length == 0){
			g_InvalidInput = true;
			return 0;
		}
		g_InvalidInput = false;
		int nGreatestSum = Integer.MIN_VALUE; //初始化
		int nCurSum = 0;
		
		for(int i = 0; i < nums.length; i++){
			nCurSum = max(nums[i], nGreatestSum + nums[i]);
			nGreatestSum = max(nGreatestSum, nCurSum);
		}
		
		return 0;
	}
	private int max(int num1, int num2) {
		if(num1 > num2){
			return num1;
		}else{
			return num2;
		}
	}
	
}
