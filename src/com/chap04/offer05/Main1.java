package com.chap04.offer05;

import java.util.ArrayList;

//�������´�ӡ������
public class Main1 {

	//�������������
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
		//������
		levelOrder(pTreeNode.left, level-1);
		//������
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
	
	

	// ǰ������������ݹ�
	ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<Integer> preOrderBinaryTree(BinaryTreeNode pTreeRoot) {
		if (pTreeRoot != null) {
			list.add(pTreeRoot.data); // �ȸ����
			preOrderBinaryTree(pTreeRoot.left); // �����
			preOrderBinaryTree(pTreeRoot.right); // ���ұ�
		} else {
			return null;
		}
		return list;
	}

	// ��������������ݹ�
	public ArrayList<Integer> inOrderBinaryTree(BinaryTreeNode pTreeRoot) {
		if (pTreeRoot != null) {
			inOrderBinaryTree(pTreeRoot.left); // �����
			list.add(pTreeRoot.data); // ���м�
			inOrderBinaryTree(pTreeRoot.right); // ���ұ�
		} else {
			return null;
		}
		return list;
	}

	// ��������������ݹ�
	public ArrayList<Integer> postOrderBinaryTree(BinaryTreeNode pTreeNode) {
		if (pTreeNode != null) {
			postOrderBinaryTree(pTreeNode.left); // �����
			postOrderBinaryTree(pTreeNode.right); // ���ұ�
			list.add(pTreeNode.data); // ���м�
		} else {
			return null;
		}
		return list;
	}
}
