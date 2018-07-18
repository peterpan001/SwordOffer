package com.chap04.offer07;

import java.util.ArrayList;
import java.util.Stack;
//二叉树中和为某一值的路径
public class Main {

	public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode pRoot, int expectedSum){
		if(pRoot == null){
			return null;
		}
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> path = new Stack<Integer>();
		findPath(pRoot, expectedSum, path, pathList);
		return pathList;
	}

	private void findPath(BinaryTreeNode pRoot, int expectedSum,
			Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
		if(pRoot == null){
			return ;
		}
		if(pRoot.leftNode == null && pRoot.rightNode == null){
			if(pRoot.value == expectedSum){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i : path) {
					list.add(i);
				}
				list.add(pRoot.value);
				pathList.add(list);
			}
		}else{//如果不是叶子结点将它放到栈里面，并遍历它的子结点
			path.push(pRoot.value);
			findPath(pRoot.leftNode, expectedSum - pRoot.value, path, pathList);
			findPath(pRoot.rightNode, expectedSum - pRoot.value, path, pathList);
			//在返回父结点之前，在路径上删除当前结点
			path.pop();
		}
		
	}
	public static void main(String[] args){  
        BinaryTreeNode root1 = new BinaryTreeNode();  
        BinaryTreeNode node1 = new BinaryTreeNode();  
        BinaryTreeNode node2 = new BinaryTreeNode();  
        BinaryTreeNode node3 = new BinaryTreeNode();  
        BinaryTreeNode node4 = new BinaryTreeNode();  
        root1.value = 10;
        node1.value = 5;
        node2.value = 12;
        node3.value = 4;
        node4.value = 7;
        root1.leftNode = node1;
        root1.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        Main m1 = new Main();
        ArrayList<ArrayList<Integer>> list = m1.findPath(root1, 22);
        System.out.println(list);
    }  
}
