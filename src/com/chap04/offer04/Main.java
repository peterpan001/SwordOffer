package com.chap04.offer04;

import java.util.Stack;
//ջ��ѹ��͵�������
public class Main {

	public boolean isPopOrder(int pPush[], int pPop[]){
		boolean bPossible = false;
		if(pPush.length == 0 || pPop.length == 0){
			bPossible = false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		//���ڱ�ʶ�������е�λ��
		int popIndex = 0;
		for (int i = 0; i < pPush.length; ++i) {
			stack.push(pPush[i]);
			while(!stack.isEmpty() && stack.peek() == pPop[popIndex]){
				stack.pop(); //��ջ
				++popIndex;
			}
		}
		if(stack.isEmpty() && (pPop.length-1) == popIndex){
			bPossible = true;
		}else{
			bPossible = false;
		}
		return bPossible;
	}
}
