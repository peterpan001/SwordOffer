package com.chap04.offer09;

public class Main2 {

	BinaryTreeNode head = null; //定义链表当前结点
	BinaryTreeNode realHead = null; //定义链表头部的结点
	//中序递归遍历修改链表指针即可实现
	public BinaryTreeNode convert(BinaryTreeNode pRootOfTree){
		if(pRootOfTree == null){
			return null;
		}
		convert(pRootOfTree.m_pLeft); //左
		 
		if(head == null){ //根
			head = pRootOfTree;
			realHead = pRootOfTree;
		}else{
			head.m_pRight = pRootOfTree;
			pRootOfTree.m_pLeft = head;
			head = pRootOfTree;
		}
		
		convert(pRootOfTree.m_pRight); //右
		return realHead;
	}
	//main方法测试
	public static void main(String[] args) {
		Main2 m2 = new Main2();
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.m_nValue = 1;
		
		BinaryTreeNode node2= new BinaryTreeNode();
		node2.m_nValue = 2;
		
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.m_nValue = 3;
		   
		node2.m_pLeft = node1;
		node2.m_pRight = node3;
		BinaryTreeNode head = m2.convert(node2);
		System.out.println(head.m_nValue);
		System.out.println(head.m_pRight.m_nValue);
		System.out.println(head.m_pRight.m_pRight.m_nValue);
	}
}
