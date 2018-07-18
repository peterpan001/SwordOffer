package com.chap01.offer02;

import org.junit.Test;
/**
 * 测试求链表中倒数第k个结点
 * @author Peter
 *
 */
public class ListNodeTest {

	@Test
	public void testListNode(){
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
		ListNode kListNode = Main.CountdownKListNode(ln1, 3);
		System.out.println(kListNode.data);

	}
}

