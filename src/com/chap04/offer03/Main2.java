package com.chap04.offer03;

import java.util.Stack;
//包含max函数的栈
public class Main2 {

	Stack<Integer> data = new Stack<Integer>(); //存放元素栈
	Stack<Integer> max = new Stack<Integer>(); //辅助栈，data栈中每次进入一个元素，min辅助栈就存放当前data栈中的最大元素
	
	public void stackWithMaxPush(int item){ 
		data.push(item);
		if(max.size() == 0 || item > max.peek()){
			max.push(item);
		}else{
			max.push(max.peek());
		}
	}
	
	public void stackWithMaxPop(){
		if(max.size() > 0 && data.size() > 0){
			data.pop();
			max.pop();
		}
	}
	
	public int stackWithDataTop(){
		if(data.size() > 0){
			return data.peek();
		}
		return 0;
	}
	
	public int stackWithMaxMax(){
		if(data.size() > 0 && max.size() > 0){
			return max.peek();
		}
		return 0;
	}
}
