package com.chap04.offer06;

public class Main {

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
		int root = sequence[end]; //������������һ�����Ϊ�����
		
		//�ڶ������������������Ľ��С�ڸ����
		int i = 0;
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
		if(i > start){
			left = verifySquenceOfBST1(sequence, start, i-1);
		}
		//�ж��������ǲ��Ƕ�����
		boolean right = true;
		if(i < end){
			right = verifySquenceOfBST1(sequence, i, end -1); 
		}
		return (left && right);
	}
}
