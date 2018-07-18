package com.chap04.offer07;

import java.util.ArrayList;
import java.util.Stack;
//二叉树中和为某一值的路径
public class Main1 {

	
	public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode pRoot, int expectedSum){
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){ //如果此树为空则直接返回
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();//定义栈来存储一条路径
		findPath(pRoot, expectedSum, path, pathList); //调用查找方法
 		return pathList;
	}

	private void findPath(BinaryTreeNode pRoot, int expectedSum,
			Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
		if(pRoot == null){
			return;
		}
		//判断其是不是叶子结点，如果是看其是不是等于期望值，是的话直接添加到ArrayList集合当中
		if(pRoot.leftNode == null && pRoot.rightNode == null){
			if(pRoot.value == expectedSum){ //如果等于期望值，则添加到list集合中
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int value : path) {
					list.add(value);
				}
				list.add(pRoot.value);
				pathList.add(list);
			}
		}else{
			//不是叶子结点，前序遍历，将当前结点值放入path栈中
			path.push(pRoot.value);
			findPath(pRoot.leftNode, expectedSum - pRoot.value, path, pathList);
			findPath(pRoot.rightNode, expectedSum - pRoot.value, path, pathList);
			//在返回到父结点之前，在路径上删除当前结点的值
			path.pop();
		}
		
	}
	
}
