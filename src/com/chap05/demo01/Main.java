package com.chap05.demo01;
/**
 * �����г��ִ�������һ�������
 * @author Peter
 *
 */
public class Main {

	public int moreThanHalfNum(int nums[]){
		if(nums == null || nums.length == 0){ //�������Ϊ�ջ������鳤��Ϊ0������0
			return 0;
		}
		int len = nums.length;
		int start = 0;
		int middle = len >> 1;
		int end = len - 1;
		int index = partition(nums, start, end); //���ÿ�������
		
		while(index!=middle){
			if(index > middle){ //��������±����n/2����ô��λ��Ӧ��λ��������ߣ�������������߲��ֵ������в���
				end = index - 1;
				index = partition(nums, start, end);
			}else{ //��������±�С��n/2����ô��λ��Ӧ��λ�������ұߣ������������ұ߲��ֵ������в���
				start = index + 1; 
				index = partition(nums, start, end);
			}
		}
		int result = nums[middle];
		if(checkMoreThanHalf(nums, result)){ //�ж�һ��result���ֵĴ����Ƿ񳬹�result���������ؽ�����򷵻�0
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
			swap(nums, start, end);//����λ�ã�ʹ����privotkey��ֵλ�������ұ�
			
			while(start < end && privotKey >= nums[start]){
				++start;
			}
			swap(nums, start, end);//����λ�ã�ʹС��privotkey��ֵλ���������
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
