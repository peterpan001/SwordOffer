package com.chap04.offer01;

import java.util.Stack;
//�������ľ���
public class Main {

	public void mirrorRecursively(BinaryTreeNode pNode){
		if(pNode == null){ //û����ֱ�ӷ���
			return;
		}
		if(pNode.left == null && pNode.right == null){ //������ҽ��Ϊ�գ�Ҳֱ�ӷ���
			return;
		}
		BinaryTreeNode pTemp = pNode.left; //�����������ҽ��
		pNode.left = pNode.right;
		pNode.right = pTemp;
		if(pNode.left!=null){ //������㲻Ϊ�գ�����
			mirrorRecursively(pNode.left);
		}
		if(pNode.right != null){ //����ҽ�㲻Ϊ�գ�����
			mirrorRecursively(pNode.right);
		}
	}
	
	public void mirrorRecursively1(BinaryTreeNode pNode){
		if(pNode == null){
			return ;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(pNode);
		while(!stack.isEmpty()){
			BinaryTreeNode treeNode = stack.pop();
			if(treeNode.left!=null || treeNode.right!=null){
				BinaryTreeNode tempNode = treeNode.left;
				treeNode.left = treeNode.right;
				treeNode.right = tempNode;
			}
			if(treeNode.left!=null){
				stack.push(treeNode.left);
			}
			if(treeNode.right!=null){
				stack.push(treeNode.right);
			}
		}
	}
	
}
