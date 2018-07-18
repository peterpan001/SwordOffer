package com.chap03.offer06;

import com.chap01.offer02.ListNode;
//��ת����
public class Main {

	public ListNode reverseList(ListNode pHead){
		if(pHead == null){
			return null;
		}
		if(pHead.next == null){
			return pHead;
		}
		ListNode preNode = null;
		ListNode curNode = pHead;
		ListNode nextNode = pHead.next;
		ListNode newHead = null;
		if(curNode != null){
			nextNode = curNode.next;
			if(nextNode == null){
				newHead = curNode;
			}
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		return newHead;
	}
	
	
	public ListNode reverseList1(ListNode pHead){
	
		ListNode pReversedHead = null; //���巴ת���ͷ���
		ListNode pNode = pHead; //pNodeָ��ǰ���
		ListNode pPrev = null; //���嵱ǰ����ǰ���
		while(pNode!=null){
			ListNode pNext = pNode.next; //�ȵ�ǰpNode��������1��������ӵ�ǰ��������һ�����λ��
			if(pNext == null){
				pReversedHead = pNode;
			}
			pNode.next = pPrev; //�޸ĵ�ǰָ���ָ����ָ��ǰpPrev,�൱���ж��������µ�ǰ���
			pPrev = pNode; //����ǰ��㸴�Ƹ�ǰһ�����,pNode�Ľ�����Ϊ1
			pNode = pNext; //��pNext�����Ƹ�pNode
			
		}
		return pReversedHead;
	}
	
	
	
	
	
	public ListNode reverseList2(ListNode pHead){
		ListNode pReversedHead = null; //��ת����ĵ�����洢ͷ���
		ListNode pNode = pHead; //����pNodeָ��pHead;
		ListNode pPrev = null; //����洢ǰһ�����
		while(pNode != null){
			ListNode pNext = pNode.next; //����pNextָ��pNode����һ�����
			if(pNext==null){ //���pNode����һ�����Ϊ�գ���pNode��Ϊ���
				pReversedHead = pNode;
			}
			pNode.next = pPrev; //�޸�pNode��ָ����ָ��pPrev
			pPrev = pNode; //��pNode��㸴�Ƹ�pPrev
			pNode = pNext; //��pNode����һ����㸴�Ƹ�pNode
		}
		return pReversedHead;
	}
	
	public ListNode reverseList3(ListNode pHead){
		if(pHead==null || pHead.next == null){
			return pHead;
		}
		ListNode pNext = pHead.next;
		pHead.next = null;
		ListNode reverseHead = reverseList3(pNext);
		pNext.next = pHead;
		return reverseHead;
	}
	public static void main(String[] args) {
		ListNode ln1 = new ListNode();
		ListNode ln2 = new ListNode();
		ListNode ln3 = new ListNode();
		ListNode ln4 = new ListNode();
		ListNode ln5 = new ListNode();
		ListNode ln6 = new ListNode();
		ListNode ln7 = new ListNode();
		ListNode ln8 = new ListNode();
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		ln6.next = ln7;
		ln7.next = ln8;
		ln8.next = null;
		ln1.data = 1;
		ln2.data = 2;
		ln3.data = 3;
		ln4.data = 4;
		ln5.data = 5;
		ln6.data = 6;
		ln7.data = 7;
		ln8.data = 8;
		Main m1 = new Main();
		m1.reverseList1(ln1);
		while(ln8!=null){
			System.out.println(ln8.data);
			ln8 = ln8.next;
		}
	}
	
}
