package com.chap04.offer09;

public class Main {
	
	public BinaryTreeNode convert(BinaryTreeNode pRootOfTree){
		
		BinaryTreeNode pLastNodeInList = null;
		convertNode(pRootOfTree, pLastNodeInList);
		
		BinaryTreeNode pHeadOfList = pLastNodeInList;
		while(pHeadOfList!=null && pHeadOfList.m_pLeft!=null){
			pHeadOfList = pHeadOfList.m_pLeft;
		}
		return pHeadOfList;
	}

	private void convertNode(BinaryTreeNode pNode,
			BinaryTreeNode pLastNodeInList) {
		
		if(pNode == null){
			return ;
		}
		BinaryTreeNode pCurrent = pNode;
		if(pCurrent.m_pLeft!=null){
			convertNode(pCurrent.m_pLeft, pLastNodeInList);
		}
		pCurrent.m_pLeft = pLastNodeInList;
		if(pLastNodeInList!=null){
			pLastNodeInList.m_pRight = pCurrent;
		}
		pLastNodeInList = pCurrent;
		if(pCurrent.m_pRight!=null){
			convertNode(pCurrent.m_pRight, pLastNodeInList);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.m_nValue = 1;
		
		BinaryTreeNode node2= new BinaryTreeNode();
		node2.m_nValue = 2;
		
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.m_nValue = 3;
		
		node2.m_pLeft = node1;
		node2.m_pRight = node3;
		
		Main m1 = new Main();
		BinaryTreeNode pHeadOfList = m1.convert(node2);
		System.out.println(pHeadOfList);
	}
}
