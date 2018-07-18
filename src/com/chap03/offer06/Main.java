package com.chap03.offer06;

import com.chap01.offer02.ListNode;
//反转链表
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
	
		ListNode pReversedHead = null; //定义反转后的头结点
		ListNode pNode = pHead; //pNode指向当前结点
		ListNode pPrev = null; //定义当前结点的前结点
		while(pNode!=null){
			ListNode pNext = pNode.next; //比当前pNode结点个数少1，即保存从当前结点起的下一个结点位置
			if(pNext == null){
				pReversedHead = pNode;
			}
			pNode.next = pPrev; //修改当前指针的指针域指向前pPrev,相当于切断链表留下当前结点
			pPrev = pNode; //将当前结点复制给前一个结点,pNode的结点个数为1
			pNode = pNext; //将pNext链复制给pNode
			
		}
		return pReversedHead;
	}
	
	
	
	
	
	public ListNode reverseList2(ListNode pHead){
		ListNode pReversedHead = null; //反转过后的单链表存储头结点
		ListNode pNode = pHead; //定义pNode指向pHead;
		ListNode pPrev = null; //定义存储前一个结点
		while(pNode != null){
			ListNode pNext = pNode.next; //定义pNext指向pNode的下一个结点
			if(pNext==null){ //如果pNode的下一个结点为空，则pNode即为结果
				pReversedHead = pNode;
			}
			pNode.next = pPrev; //修改pNode的指针域指向pPrev
			pPrev = pNode; //将pNode结点复制给pPrev
			pNode = pNext; //将pNode的下一个结点复制给pNode
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
