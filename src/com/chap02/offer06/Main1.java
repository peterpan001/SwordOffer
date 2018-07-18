package com.chap02.offer06;

import java.util.Stack;
//利用栈模拟队列
public class Main1 {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void appendTail(int item){
		stack1.push(item);
	}
	
	public int deleteHead(){
		if(stack2.size() <= 0){
			while(stack1.size() > 0){
				int data = stack1.pop();
				stack2.push(data);
			}
		}
		if(stack2.size() == 0){
			try {
				throw new Exception("Queue is empty.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int head = stack2.pop();
		return head;
	}
	
	public static void main(String[] args) {
		Main1 m1 = new Main1();
		m1.appendTail(1);
		m1.appendTail(2);
		m1.appendTail(3);
		System.out.println(m1.deleteHead());
		m1.appendTail(4);
		System.out.println(m1.deleteHead());
		m1.appendTail(5);
		System.out.println(m1.deleteHead());
		System.out.println(m1.deleteHead());
		System.out.println(m1.deleteHead());
	}
}
