package com.chap04.offer05;

import java.util.ArrayList;

//从上往下打印二叉树
public class Main1 {

	//层序遍历二叉树
	private int depth(BinaryTreeNode pTreeRoot){
		if(pTreeRoot==null){
			return 0;
		}
		int l = depth(pTreeRoot.left);
		int r = depth(pTreeRoot.right);
		if(l > r){
			return l + 1;
		}else{
			return r + 1;
		}
	}
	
	private void levelOrder(BinaryTreeNode pTreeNode, int level) {
		if(pTreeNode == null || level < 1){
			return ;
		}
		if(level == 1){
			System.out.print(pTreeNode.data+ " ");
			return ;
		}
		//左子树
		levelOrder(pTreeNode.left, level-1);
		//右子树
		levelOrder(pTreeNode.right, level-1);
	}
	
	public void printFromTopToBottom(BinaryTreeNode pTreeRoot){
		if(pTreeRoot==null){
			return ;
		}
		int depth = depth(pTreeRoot);
		for (int i = 1; i <= depth; ++i) {
			levelOrder(pTreeRoot, i);
		}
	}
	
	

	// 前序遍历二叉树递归
	ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<Integer> preOrderBinaryTree(BinaryTreeNode pTreeRoot) {
		if (pTreeRoot != null) {
			list.add(pTreeRoot.data); // 先根结点
			preOrderBinaryTree(pTreeRoot.left); // 再左边
			preOrderBinaryTree(pTreeRoot.right); // 再右边
		} else {
			return null;
		}
		return list;
	}

	// 中序遍历二叉树递归
	public ArrayList<Integer> inOrderBinaryTree(BinaryTreeNode pTreeRoot) {
		if (pTreeRoot != null) {
			inOrderBinaryTree(pTreeRoot.left); // 先左边
			list.add(pTreeRoot.data); // 再中间
			inOrderBinaryTree(pTreeRoot.right); // 再右边
		} else {
			return null;
		}
		return list;
	}

	// 后序遍历二叉树递归
	public ArrayList<Integer> postOrderBinaryTree(BinaryTreeNode pTreeNode) {
		if (pTreeNode != null) {
			postOrderBinaryTree(pTreeNode.left); // 先左边
			postOrderBinaryTree(pTreeNode.right); // 再右边
			list.add(pTreeNode.data); // 再中间
		} else {
			return null;
		}
		return list;
	}
}
