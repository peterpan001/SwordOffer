package com.chap01.offer02;

/**
 * ���������е�����k�����
 * 
 * @author Peter
 */
public class Main {

	// ���������е�����k�����
	public static ListNode CountdownKListNode(ListNode head, int k) {
		// �ж������Ƿ�Ϊ���Լ�k�Ƿ�ΪС��0����
		if (head == null || k < 0) { // ������Ϊ�գ����ҵĵ�����k�����k����С��0
			return null;
		}
		// ��ʼʱ�����������ʹ�䶼ָ��ͷ���
		ListNode aNode = head;
		ListNode bNode = head;
		// ʹaNode�ﵽ��k�����
		for (int i = 0; i < k - 1; i++) {
			if (aNode.next != null)
				aNode = aNode.next;
			else {
				return null; // ����̫�̣��򲻵�k�����
			}
		}
		while (aNode.next != null) {
			aNode = aNode.next;
			bNode = bNode.next;
		}
		return bNode; // bNode��Ϊ������k�����
	}
}
