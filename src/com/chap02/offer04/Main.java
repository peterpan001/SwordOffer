package com.chap02.offer04;

import java.util.Stack;

import com.chap01.offer02.ListNode;

public class Main {

	public static void printListReversinglyByStack(ListNode listNode){
		if(listNode == null){
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode!=null){
			stack.push(listNode.data);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static void printListReverseinglyByRecursion(ListNode listNode){
		if(listNode!=null){
			if(listNode.next!=null){
				printListReverseinglyByRecursion(listNode.next);
			}
			System.out.print(listNode.data + " ");
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
    	//ListNode ln1 = new ListNode();
		//ln1=null;
		printListReversinglyByStack(ln1);
		System.out.println();
		printListReverseinglyByRecursion(ln1);
		
	}
}
