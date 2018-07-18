package com.chap04.offer08;

public class Main {

	//����ԭʼ���A������洴��A'��
	public void cloneNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			//����pCloned��㼴A'���ʹ��ָ��ԭʼ������A������һ���B,����A'��m_pSibling����Ϊnull
			ComplexListNode pCloned = new ComplexListNode();
			pCloned.m_nValue = pNode.m_nValue;
			pCloned.m_pNext = pNode.m_pNext;
			pCloned.m_pSibling = null;
			//��A���ָ��A�����
			pNode.m_pNext = pCloned;
			//ʹpNodeָ��A����һ���B���Դ�ѭ���޸�(��ʱ�м��ѽ���¡���A��������ԭʼ�б�)
			pNode = pCloned.m_pNext;
		}
	}
	
	//����ÿ������m_pSibling(ע��m_pSiblingΪ�ս�㲻���޸�)
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
	
	//�������
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
	
	//�����������������Ϊ��������ĸ���
	public ComplexListNode clone(ComplexListNode pHead){
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
		return reconnectNodes(pHead);
	}
}
