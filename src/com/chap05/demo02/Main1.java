package com.chap05.demo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * 最小的k个数
 * @author Peter
 *
 */
public class Main1 {

	public static ArrayList<Integer> getLeastNumbers(int []nums, int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int lens = nums.length;
		if(nums == null || lens == 0 || k > lens || k <= 0){
			return list;
		}
		TreeSet<Integer> kSet = new TreeSet<Integer>();
		for (int i = 0; i < lens; i++) {
			if(kSet.size() < k){
				kSet.add(nums[i]);
			}else if(nums[i] < kSet.last()){
				kSet.remove(kSet.last());
				kSet.add(nums[i]);
			}
		}
		Iterator<Integer> iterator = kSet.iterator();
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		return list;
	}
	
	public static void main(String[] args) {
		int nums[] = {4, 5, 1, 6, 2, 7, 3, 8};
		Main1 m1 = new Main1();
		ArrayList<Integer> list = m1.getLeastNumbers(nums, 4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
