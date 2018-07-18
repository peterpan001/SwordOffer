package com.chap04.offer01;

import java.util.Stack;
//二叉树的镜像
public class Main {

	public void mirrorRecursively(BinaryTreeNode pNode){
		if(pNode == null){ //没有树直接返回
			return;
		}
		if(pNode.left == null && pNode.right == null){ //如果左右结点为空，也直接返回
			return;
		}
		BinaryTreeNode pTemp = pNode.left; //交换树的左右结点
		pNode.left = pNode.right;
		pNode.right = pTemp;
		if(pNode.left!=null){ //如果左结点不为空，继续
			mirrorRecursively(pNode.left);
		}
		if(pNode.right != null){ //如果右结点不为空，继续
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
