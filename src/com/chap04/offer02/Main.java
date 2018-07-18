package com.chap04.offer02;

import java.util.ArrayList;

public class Main {

	public ArrayList<Integer> printMatrixClockwisely(int [][]nums){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rows = nums.length;
		int cols = nums[0].length;
		if(nums == null || cols <= 0 || rows <= 0){
			return null;
		}
		int start = 0;
		while(cols > start*2 && rows > start*2){
			printMatrixInCircle(list, nums, cols, rows, start);
			++start;
		}
		return list;
	}

	private void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
			int cols, int rows, int start) {
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;
		
		//�����Ҵ�ӡһ��
		for (int i = start; i <= endX; ++i) {
			int number = nums[start][i];
			list.add(number);
		}
		//���ϵ��´�ӡһ��
		if(start < endY){
			for (int i = start + 1; i <= endY; ++i) {
				int number = nums[i][endX];
				list.add(number);
			}
		}
		//���������ӡһ��
		if(start < endX && start < endY){
			for (int i = endX-1; i >= start; --i) {
				int number = nums[endY][i];
				list.add(number);
			}
		}
		//�������ϴ�ӡһ��
		if(start < endX && start < endY - 1){
			for (int i = endY-1; i >= start + 1; --i) {
				int number = nums[i][start];
				list.add(number);
			}
		}
	}
}
