package com.chap04.offer06;

public class BinaryTreeNode {

	public int data; 
	
	public BinaryTreeNode left;
	
	public BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" + right
				+ "]";
	}
}
