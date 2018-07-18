package com.chap03.offer05;
//判断链表是否为环形
public class Main {

	//false为不是环形结构，true为环形结构
	public boolean isRingStructure(ListNode head){
		if(head == null){
			return false;
		}
		ListNode pNode = head;
		ListNode qNode = head;
		while(qNode.next!=null){
			if(qNode.next.next != null){
				qNode = qNode.next.next;
			}else{
				return false;
			}
			if(qNode == pNode){
				return true;
			}
			pNode = pNode.next;
		}
		return false;
	}
	
	public ListNode getMidNode(ListNode head){
		if(head == null){
			return null;
		}
		ListNode pNode = head;
		ListNode qNode = head;
		while(qNode.next != null){
			if(qNode.next.next != null){
				pNode = pNode.next;
				qNode = qNode.next.next;
			}else{
				pNode = pNode.next;
			}
		}
		return pNode;
	}
	
	public static void main(String[] args) {
//		ListNode ln1 = new ListNode();
//		ListNode ln2 = new ListNode();
//		ListNode ln3 = new ListNode();
//		ListNode ln4 = new ListNode();
//		ListNode ln5 = new ListNode();
//		ListNode ln6 = new ListNode();
//		ListNode ln7 = new ListNode();
//		ListNode ln8 = new ListNode();
//		ln1.next = ln2;
//		ln2.next = ln3;
//		ln3.next = ln4;
//		ln4.next = ln5;
//		ln5.next = ln6;
//		ln6.next = ln7;
//		ln7.next = ln8;
//		ln8.next = null;
//		ln1.data = 1;
//		ln2.data = 2;
//		ln3.data = 3;
//		ln4.data = 4;
//		ln5.data = 5;
//		ln6.data = 6;
//		ln7.data = 7;
//		ln8.data = 8;
//		
		ListNode ln1 = new ListNode();
		ln1.data = 1;
		ln1.next = null;
		
		ListNode ln2 = new ListNode();
		ln2.data = 2;
		ln2.next = null;
		
//		ListNode ln3 = new ListNode();
//		ln3.data = 3;
//		ln3.next = null;
		
		Main m1 = new Main();
		ListNode node = m1.getMidNode(ln1);
		System.out.println(node.data);
	}
}
