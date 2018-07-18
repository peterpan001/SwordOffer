package com.chap04.offer09;

import java.util.Stack;

public class Main3 {

	public BinaryTreeNode convert(BinaryTreeNode pRootOfTree){
		if(pRootOfTree == null){
			return null;
		}
		BinaryTreeNode list = null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(pRootOfTree != null || !stack.isEmpty()){
			if(pRootOfTree!=null){
				stack.push(pRootOfTree);
				pRootOfTree = pRootOfTree.m_pRight;
			}else{
				pRootOfTree = stack.pop();
				if(list == null){
					list = pRootOfTree;
				}else{
					list.m_pLeft = pRootOfTree;
					pRootOfTree.m_pRight = list;
					list = pRootOfTree;
				}
				pRootOfTree = pRootOfTree.m_pLeft;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Main3 m3 = new Main3();
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.m_nValue = 1;
		
		BinaryTreeNode node2= new BinaryTreeNode();
		node2.m_nValue = 2;
		
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.m_nValue = 3;
		   
		node2.m_pLeft = node1;
		node2.m_pRight = node3;
		BinaryTreeNode head = m3.convert(node2);
		System.out.println(head.m_nValue);
		System.out.println(head.m_pRight.m_nValue);
		System.out.println(head.m_pRight.m_pRight.m_nValue);
	}
}
