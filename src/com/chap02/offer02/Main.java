package com.chap02.offer02;
//��ά�����в���
public class Main {

	//�����Ͻǿ�ʼ����targetԪ��
	public boolean find(int [][]array, int target){
		//�����ж����鲻Ϊ�գ�����ֱ�ӷ���false
		if(array!=null && array.length > 0 && array[0].length > 0){
			int row = 0; //��ʼ���е�ֵ
			int col = array[0].length - 1; //��ʼ���е�ֵ
			//ѭ�������жϣ�Ѱ��target
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
	
	//�����½ǿ�ʼ����targetԪ��
	public boolean find1(int [][]array, int target){
		//�����ж����鲻Ϊ�գ�����ֱ�ӷ���false
		if(array!=null && array.length > 0 && array[0].length > 0){
			int row = array.length - 1; //��ʼ���е�ֵ
			int col = 0; //��ʼ���е�ֵ
			//ѭ�������жϣ�Ѱ��target
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
