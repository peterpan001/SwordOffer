package com.chap04.offer08;

import java.util.HashMap;

public class Main1 {
	
	public ComplexListNode clone(ComplexListNode pHead){
		
		if(pHead == null){
			return null;
		}
		HashMap<ComplexListNode, ComplexListNode> map = new HashMap<ComplexListNode, ComplexListNode>();
		ComplexListNode pClonedHead = new ComplexListNode(pHead.m_nValue); //���������ͷ���
		ComplexListNode pNode = pHead, pClonedNode = pClonedHead;
		map.put(pNode, pClonedNode);
		
		//��һ����hashMap���棬ԭ����ڵ�ӳ�临������ڵ�
		while(pNode.m_pNext != null){
			pClonedNode.m_pNext = new ComplexListNode(pNode.m_pNext.m_nValue);
			pNode = pNode.m_pNext;
			pClonedNode = pClonedNode.m_pNext;
			map.put(pNode, pClonedNode);
		}
		
		//�ڶ������ҵ���Ӧ��m_pSibling
		pNode = pHead;
		pClonedNode = pClonedHead;
		while(pClonedNode!=null){
			pClonedNode.m_pSibling = map.get(pNode.m_pSibling);
			pNode = pNode.m_pNext;
			pClonedNode = pClonedNode.m_pNext;
		}
		return pClonedHead;
	}
	
}
