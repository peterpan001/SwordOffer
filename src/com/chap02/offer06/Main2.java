package com.chap02.offer06;

import java.util.LinkedList;
import java.util.Queue;
//利用队列模拟栈
public class Main2 {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	//模拟栈压入数据
	public void push(int item){
		//如果queue1队列和queue2队列都为空，优先选择queue1队列添加元素
		if(queue1.isEmpty() && queue2.isEmpty()){
			queue1.add(item);
			return;
		}
		//如果队列1为空，向队列2添加元素
		if(queue1.isEmpty()){
			queue2.add(item);
			return;
		}
		//如果队列2为空，向队列1添加元素
		if(queue2.isEmpty()){
			queue1.add(item);
			return;
		}
	}
	
	//模拟栈出数据
	public int pop(){
		//如果两个队列都没有元素可以弹出异常
		if(queue1.isEmpty() && queue2.isEmpty()){
			try {
				throw new Exception("栈为空!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//如果queue1为空，将queue2的前queue2.size()-1个元素弹出放入queue1队列，queue2的最后一个元素直接弹出
		if(queue1.isEmpty()){
			while(queue2.size() > 1){
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		//如果queue2为空，将queue1的前queue1.size()-1个元素弹出放入queue2队列，queue1的最后一个元素直接弹出
		if(queue2.isEmpty()){
			if(queue1.size() > 1){
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return 0;
	}
}
