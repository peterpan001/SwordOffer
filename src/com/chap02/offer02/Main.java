package com.chap02.offer02;
//二维数组中查找
public class Main {

	//从右上角开始查找target元素
	public boolean find(int [][]array, int target){
		//首先判断数组不为空，否则直接返回false
		if(array!=null && array.length > 0 && array[0].length > 0){
			int row = 0; //初始化行的值
			int col = array[0].length - 1; //初始化列的值
			//循环遍历判断，寻找target
			while(row <= array.length-1 && col >= 0){
				if(target == array[row][col]){
					return true;
				}else if(target < array[row][col]){
					col--;
				}else{
					row++;
				}
			}
		}
		return false;
	}
	
	//从左下角开始查找target元素
	public boolean find1(int [][]array, int target){
		//首先判断数组不为空，否则直接返回false
		if(array!=null && array.length > 0 && array[0].length > 0){
			int row = array.length - 1; //初始化行的值
			int col = 0; //初始化列的值
			//循环遍历判断，寻找target
			while(row >= 0 && col <= array[0].length - 1){
				if(target == array[row][col]){
					return true;
				}else if(target < array[row][col]){
					row--;
				}else{
					col++;
				}
			}
		}
		return false;
	}
}
