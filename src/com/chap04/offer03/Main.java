package com.chap04.offer03;

import java.util.Stack;
//����min������ջ
public class Main {

	Stack<Integer> data = new Stack<Integer>(); //���Ԫ��ջ
	Stack<Integer> min = new Stack<Integer>(); //����ջ��dataջ��ÿ�ν���һ��Ԫ�أ�min����ջ�ʹ�ŵ�ǰdataջ�е���СԪ��
	
	//dataջ��minջ����Ԫ��
	public void stackWithMinPush(int item){
		data.push(item);
		if(min.size() > 0 || item < min.peek()){
			min.push(item);
		}else{
			min.push(min.peek());
		}
	}
	
	//dataջ��minջ����Ԫ��
	public void stackWithMinPop(){
		if(data.size() > 0 && min.size() > 0){
			data.pop();
			min.pop();
		}
	}
	
	//dataջ��ջ��Ԫ��
	public int stackWithDataTop(){
		if(data.size() > 0){
			return data.peek();
		}
		return 0;
	}
	//minջ��ջ��Ԫ�أ�ջ��Ԫ��Ϊdataջ������Ԫ�ص���СԪ��
	public int stackWithMinMin(){
		if(data.size() > 0 && min.size() > 0){
			return min.peek();
		}
		return 0;
	}
}
