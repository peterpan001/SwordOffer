package com.chap04.offer06;
//看是不是二叉搜索树
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
		int root = sequence[start]; //后序遍历的最后一个结点为根结点
		
		//在二叉搜索树中左子树的结点小于根结点
		int i = 1;
		for(; i < end; ++i){
			if(sequence[i] > root){
				break;
			}
		}
		
		//在二叉搜索树中右子树的结点大于根结点
		int j = i;
		for(; j < end; ++j){
			if(sequence[j] < root){
				return false;
			}
		}
		//判断左子树是不是二叉树
		boolean left = true;
		if(i > start+1){
			left = verifySquenceOfBST1(sequence, start+1, i-1);
		}
		//判断右子树是不是二叉树
		boolean right = true;
		if(i < end){
			right = verifySquenceOfBST1(sequence, i, end); 
		}
		return (left && right);
	}
}
