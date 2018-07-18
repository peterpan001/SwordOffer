package com.chap04.offer08;

import java.util.HashMap;

public class Main1 {
	
	public ComplexListNode clone(ComplexListNode pHead){
		
		if(pHead == null){
			return null;
		}
		HashMap<ComplexListNode, ComplexListNode> map = new HashMap<ComplexListNode, ComplexListNode>();
		ComplexListNode pClonedHead = new ComplexListNode(pHead.m_nValue); //复制链表的头结点
		ComplexListNode pNode = pHead, pClonedNode = pClonedHead;
		map.put(pNode, pClonedNode);
		
		//第一步，hashMap保存，原链表节点映射复制链表节点
		while(pNode.m_pNext != null){
			pClonedNode.m_pNext = new ComplexListNode(pNode.m_pNext.m_nValue);
			pNode = pNode.m_pNext;
			pClonedNode = pClonedNode.m_pNext;
			map.put(pNode, pClonedNode);
		}
		
		//第二步：找到对应的m_pSibling
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
