package com.chap04.offer03;

import java.util.Stack;
//����max������ջ
public class Main2 {

	Stack<Integer> data = new Stack<Integer>(); //���Ԫ��ջ
	Stack<Integer> max = new Stack<Integer>(); //����ջ��dataջ��ÿ�ν���һ��Ԫ�أ�min����ջ�ʹ�ŵ�ǰdataջ�е����Ԫ��
	
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
