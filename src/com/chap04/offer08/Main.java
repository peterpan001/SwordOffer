package com.chap04.offer08;

public class Main {

	//根据原始结点A在其后面创建A'。
	public void cloneNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			//创建pCloned结点即A'结点使其指向原始链表中A结点的下一结点B,不过A'的m_pSibling设置为null
			ComplexListNode pCloned = new ComplexListNode();
			pCloned.m_nValue = pNode.m_nValue;
			pCloned.m_pNext = pNode.m_pNext;
			pCloned.m_pSibling = null;
			//将A结点指向A’结点
			pNode.m_pNext = pCloned;
			//使pNode指向A的下一结点B并以此循环修改(此时中间已将克隆结点A‘插入了原始列表)
			pNode = pCloned.m_pNext;
		}
	}
	
	//设置每个结点的m_pSibling(注：m_pSibling为空结点不做修改)
	public void connectSiblingNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode!=null){
			ComplexListNode pCloned = pNode.m_pNext;
			if(pNode.m_pSibling!=null){
				pCloned.m_pSibling = pNode.m_pSibling.m_pNext;
			}
			pNode = pCloned.m_pNext;
		}
	}
	
	//拆分链表
	public ComplexListNode reconnectNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		ComplexListNode pClonedHead = null;
		ComplexListNode pClonedNode = null;
		if(pNode!=null){
			pClonedHead = pClonedNode = pNode.m_pNext;
			pNode.m_pNext = pClonedNode.m_pNext;
			pNode = pNode.m_pNext;
		}
		while(pNode!=null){
			pClonedNode.m_pNext = pNode.m_pNext;
			pClonedNode = pClonedNode.m_pNext;
			pNode.m_pNext = pClonedNode.m_pNext;
			pNode = pNode.m_pNext;
		}
		return pClonedHead;
	}
	
	//上面的三步合起来即为复杂链表的复制
	public ComplexListNode clone(ComplexListNode pHead){
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
		return reconnectNodes(pHead);
	}
}
