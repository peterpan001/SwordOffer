package com.chap04.offer05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//从上往下打印二叉树
public class Main {

	// 非递归
	public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode pTreeRoot) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (pTreeRoot == null) {
			return null;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(pTreeRoot);
		while (!queue.isEmpty()) {
			BinaryTreeNode treeNode = queue.poll();
			if (treeNode.left != null) {
				queue.offer(treeNode.left);
			}
			if (treeNode.right != null) {
				queue.offer(treeNode.right);
			}
			list.add(treeNode.data);
		}
		return list;
	}
	
	public void preOrderBinaryTree(BinaryTreeNode pTreeNode) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(pTreeNode!=null || !stack.isEmpty()){
			while(pTreeNode!=null){
				System.out.print(pTreeNode.data + " ");
				stack.push(pTreeNode);
				pTreeNode = pTreeNode.left;
			}
			if(!stack.isEmpty()){
				pTreeNode = stack.pop();
				pTreeNode = pTreeNode.right;
			}
		}
	}

	public void inOrderBinaryTree(BinaryTreeNode pTreeNode){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(pTreeNode!=null || !stack.isEmpty()){
			while(pTreeNode!=null){
				stack.push(pTreeNode);
				pTreeNode = pTreeNode.left;
			}
			if(!stack.isEmpty()){
				pTreeNode = stack.pop();
				System.out.print(pTreeNode.data + " ");
				pTreeNode = pTreeNode.right;
			}
		}
	}
	
}
