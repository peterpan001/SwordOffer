package com.chap03.offer07;
//合并两个排序的链表
public class Main {

	public ListNode merge(ListNode pHead1, ListNode pHead2){
		if(pHead1 == null){
			return pHead2;
		}else if(pHead2 == null){
			return pHead1;
		}
		ListNode pMergeHead = null;
		if(pHead1.data < pHead2.data){
			pMergeHead = pHead1;
			pMergeHead.next = merge(pHead1.next, pHead2);
		}else{
			pMergeHead = pHead2;
			pMergeHead.next = merge(pHead1, pHead2.next);
		}
		return pMergeHead;
	}
	
	public ListNode merge1(ListNode pHead1, ListNode pHead2){
		if(pHead1 == null){
			return pHead2;
		}else if(pHead2 == null){
			return pHead1;
		}
		ListNode pMergeHead = null;
		while(pHead1!=null && pHead2!=null){
			if(pHead1.data < pHead2.data){
				pMergeHead = pHead1;
				pHead1 = pHead1.next;
			}else{
				pMergeHead = pHead2;
				pHead2 = pHead2.next;
			}
			pMergeHead = pMergeHead.next;
			pMergeHead.next = null;
		}
		if(pHead1==null && pHead2!=null){
			pMergeHead.next = pHead2;
		}else if(pHead1!=null && pHead2 ==null){
			pMergeHead.next = pHead1;
		}
		return pMergeHead;
	}
	
	public static void main(String[] args) {
		
	}
}
