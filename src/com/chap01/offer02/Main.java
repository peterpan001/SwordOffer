package com.chap01.offer02;

/**
 * 查找链表中倒数第k个结点
 * 
 * @author Peter
 */
public class Main {

	// 查找链表中倒数第k个结点
	public static ListNode CountdownKListNode(ListNode head, int k) {
		// 判断链表是否为空以及k是否为小于0的数
		if (head == null || k < 0) { // 链表不能为空，查找的倒数第k个结点k不能小于0
			return null;
		}
		// 开始时声明两个结点使其都指向头结点
		ListNode aNode = head;
		ListNode bNode = head;
		// 使aNode达到第k个结点
		for (int i = 0; i < k - 1; i++) {
			if (aNode.next != null)
				aNode = aNode.next;
			else {
				return null; // 链表太短，打不到k个结点
			}
		}
		while (aNode.next != null) {
			aNode = aNode.next;
			bNode = bNode.next;
		}
		return bNode; // bNode即为倒数第k个结点
	}
}
