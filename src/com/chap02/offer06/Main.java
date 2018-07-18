package com.chap02.offer06;

import java.util.Stack;
/**
 * 利用两个栈形成一个队列
 * @author Peter
 *
 */
public class Main {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	//进栈操作呢
	public void appendTail(int item){
		stack1.push(item);
	}
	
	//出栈操作
	public int deleteHead(){
		while(!stack2.isEmpty()){
			return stack2.pop();
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.appendTail(1);
		m.appendTail(2);
		m.appendTail(3);
		System.out.println(m.deleteHead());
		m.appendTail(4);
		System.out.println(m.deleteHead());
		m.appendTail(5);
		System.out.println(m.deleteHead());
		System.out.println(m.deleteHead());
		System.out.println(m.deleteHead());
	}
}
