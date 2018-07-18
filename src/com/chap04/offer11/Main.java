package com.chap04.offer11;

/**
 * 正方体三组相对的面上的4个点的和都相等
 * 
 * @author Peter
 */
public class Main {

	public static void permutation(int[] nums) {
		if (nums == null || nums.length != 8) {
			return;
		}
		boolean flag = permutation(nums, 0, nums.length - 1);
		if (flag) {
			System.out.println("ok");
		} else {
			System.out.println("sorry");
		}
	}

	private static boolean permutation(int[] nums, int start, int end) {
		if (nums == null || nums.length != 8) {
			return false;
		}
		if (start == end) {
			return false;
		}
		if (isEqual(nums)) {
			return true;
		} else {
			for (int i = start; i <= end; i++) {
				int temp = nums[start];
				nums[start] = nums[i];
				nums[i] = temp;

				permutation(nums, start + 1, end);

				temp = nums[start];
				nums[start] = nums[i];
				nums[i] = temp;
			}
		}
		return false;
	}

	// 判断是否存在这样一个全排列数组使其满足
	private static boolean isEqual(int[] nums) {
		if (nums == null) {
			return false;
		}
		/*
		 * a1 + a2 + a3 + a4 == a5 + a6 + a7 + a8 a1 + a3 + a5 + a7 == a2 + a4 +
		 * a6 + a8 a1 + a2 + a5 + a6 == a3 + a4 + a7 + a8
		 */
		int result1 = nums[0] + nums[1] + nums[2] + nums[3];
		int result2 = nums[4] + nums[5] + nums[6] + nums[7];
		int result3 = nums[0] + nums[2] + nums[4] + nums[6];
		int result4 = nums[1] + nums[3] + nums[5] + nums[7];
		int result5 = nums[0] + nums[1] + nums[4] + nums[5];
		int result6 = nums[2] + nums[3] + nums[6] + nums[7];
		if (result1 == result2 && result3 == result4 && result5 == result6) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] array2 = { 1, 2, 3, 2, 3, 2, 1, 2 };
		permutation(array);
	}
}
