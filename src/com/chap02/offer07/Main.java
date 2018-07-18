package com.chap02.offer07;
//旋转数组的最小值
public class Main {

	//一般情况时的查找算法
	public int Min(int arrays[]){
		if(arrays == null){
			try {
				throw new Exception("Invalid parameters");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int index1 = 0;
		int index2 = arrays.length - 1;
		int indexMid = index1;
		while(arrays[index1] > arrays[index2]){
			if(index2 - index1 == 1){
				indexMid = index2;
				break;
			}
			indexMid = ( index1 + index2 ) / 2;
			if(arrays[index1] == arrays[index2] && arrays[indexMid] == arrays[index1]){
				return MinInOrder(arrays);
			}
			if(arrays[indexMid] >= arrays[index1]){
				index1 = indexMid;
			}else if(arrays[indexMid] <= arrays[index2]){
				index2 = indexMid;
			}
		}
		return arrays[indexMid];
	}
	//特例时的查找算法
	private int MinInOrder(int[] arrays) {
		int result = arrays[0];
		for (int i = 0; i < arrays.length; i++) {
			if(result > arrays[i]){
				result = arrays[i];
			}
		}
		return result;
	}
	//测试
	public static void main(String[] args) {
		int num1[] = {4, 5, 6, 7, 1, 2, 3};
		int num2[] = {1, 0, 1, 1, 1};
		int num3[] = {1, 1, 1, 0, 1};
		Main m1 = new Main();
		System.out.println(m1.Min(num3));
		System.out.println(m1.Min(num2));
		System.out.println(m1.Min(num1));
	}
}
