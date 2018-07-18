package com.chap04.offer06;
//���ǲ��Ƕ���������
public class Main1 {

	public boolean verifySquenceOfBST(int sequence[]){
		if(sequence == null){
			return false;
		}
		return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
	}

	private boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
		if(start < end){
			return false;
		}
		int root = sequence[start]; //������������һ�����Ϊ�����
		
		//�ڶ������������������Ľ��С�ڸ����
		int i = 1;
		for(; i < end; ++i){
			if(sequence[i] > root){
				break;
			}
		}
		
		//�ڶ������������������Ľ����ڸ����
		int j = i;
		for(; j < end; ++j){
			if(sequence[j] < root){
				return false;
			}
		}
		//�ж��������ǲ��Ƕ�����
		boolean left = true;
		if(i > start+1){
			left = verifySquenceOfBST1(sequence, start+1, i-1);
		}
		//�ж��������ǲ��Ƕ�����
		boolean right = true;
		if(i < end){
			right = verifySquenceOfBST1(sequence, i, end); 
		}
		return (left && right);
	}
}
