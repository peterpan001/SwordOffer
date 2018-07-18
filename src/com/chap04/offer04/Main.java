package com.chap04.offer04;

import java.util.Stack;
//栈的压入和弹出序列
public class Main {

	public boolean isPopOrder(int pPush[], int pPop[]){
		boolean bPossible = false;
		if(pPush.length == 0 || pPop.length == 0){
			bPossible = false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		//用于标识弹出序列的位置
		int popIndex = 0;
		for (int i = 0; i < pPush.length; ++i) {
			stack.push(pPush[i]);
			while(!stack.isEmpty() && stack.peek() == pPop[popIndex]){
				stack.pop(); //出栈
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
