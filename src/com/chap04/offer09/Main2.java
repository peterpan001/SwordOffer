package com.chap04.offer09;

public class Main2 {

	BinaryTreeNode head = null; //��������ǰ���
	BinaryTreeNode realHead = null; //��������ͷ���Ľ��
	//����ݹ�����޸�����ָ�뼴��ʵ��
	public BinaryTreeNode convert(BinaryTreeNode pRootOfTree){
		if(pRootOfTree == null){
			return null;
		}
		convert(pRootOfTree.m_pLeft); //��
		 
		if(head == null){ //��
			head = pRootOfTree;
			realHead = pRootOfTree;
		}else{
			head.m_pRight = pRootOfTree;
			pRootOfTree.m_pLeft = head;
			head = pRootOfTree;
		}
		
		convert(pRootOfTree.m_pRight); //��
		return realHead;
	}
	//main��������
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
