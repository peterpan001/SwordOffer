package com.chap03.offer03;

import com.chap01.offer02.ListNode;

//在O(1)的时间删除链表结点
public class Main {
	//O(n)时间复杂度删除pDelNode结点
	public void deleteNode1(ListNode pHead, ListNode pDelNode){
		if(pHead==null || pDelNode==null){
			return;
		}
		if(pHead == pDelNode){ //删除的是头结点
			ListNode pNext = pDelNode.next;
			pDelNode.data = pNext.data;
			pDelNode.next = pNext.next;
			return;		
		}
		//利用O(n)的时间复杂度删除结点
		for (ListNode pNode = pHead; pNode.next!=null; pNode = pNode.next) {
			if(pNode.next  == pDelNode){
				pNode.next = pNode.next.next;
				break;
			}
		}
	}
	
	//O(1)时间删除链表的结点
	public void deleteNode(ListNode pHead, ListNode pDelNode){
		if(pHead==null || pDelNode==null){
			return;
		}
		if(pDelNode.next!=null){ //要删除的结点不是尾部结点
			ListNode pNext = pDelNode.next;
			pDelNode.data = pNext.data;
			pDelNode.next = pNext.next;
		}else if(pHead == pDelNode){ //链表只有一个结点，删除头结点
			pHead = null;
			pDelNode = null;
		}else{ //链表中有多个结点，删除尾结点
			ListNode pNode = pHead;
			while(pNode.next != pDelNode){
				pNode = pNode.next;
			}
			pNode.next = null;
		}
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
		m1.deleteNode(ln1, ln2);
		while(ln1!=null){
			System.out.println(ln1.data);
			ln1 = ln1.next;
		}
	}
}
