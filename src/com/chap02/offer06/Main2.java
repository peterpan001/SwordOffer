package com.chap02.offer06;

import java.util.LinkedList;
import java.util.Queue;
//���ö���ģ��ջ
public class Main2 {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	//ģ��ջѹ������
	public void push(int item){
		//���queue1���к�queue2���ж�Ϊ�գ�����ѡ��queue1�������Ԫ��
		if(queue1.isEmpty() && queue2.isEmpty()){
			queue1.add(item);
			return;
		}
		//�������1Ϊ�գ������2���Ԫ��
		if(queue1.isEmpty()){
			queue2.add(item);
			return;
		}
		//�������2Ϊ�գ������1���Ԫ��
		if(queue2.isEmpty()){
			queue1.add(item);
			return;
		}
	}
	
	//ģ��ջ������
	public int pop(){
		//����������ж�û��Ԫ�ؿ��Ե����쳣
		if(queue1.isEmpty() && queue2.isEmpty()){
			try {
				throw new Exception("ջΪ��!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//���queue1Ϊ�գ���queue2��ǰqueue2.size()-1��Ԫ�ص�������queue1���У�queue2�����һ��Ԫ��ֱ�ӵ���
		if(queue1.isEmpty()){
			while(queue2.size() > 1){
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		//���queue2Ϊ�գ���queue1��ǰqueue1.size()-1��Ԫ�ص�������queue2���У�queue1�����һ��Ԫ��ֱ�ӵ���
		if(queue2.isEmpty()){
			if(queue1.size() > 1){
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return 0;
	}
}
