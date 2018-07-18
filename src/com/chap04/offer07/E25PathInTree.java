package com.chap04.offer07;

import java.util.Stack;

public class E25PathInTree {
	
	public void findPath(BinaryTreeNode root,int k){  
        if(root == null)  
            return;  
        Stack<Integer> stack = new Stack<Integer>();  
        findPath(root,k,stack);  
    }  
    public void findPath(BinaryTreeNode root,int k,Stack<Integer> path){  
        if(root == null)  
            return;  
        if(root.leftNode == null && root.rightNode == null){  
            if(root.value == k){  
                System.out.println("Â·¾¶¿ªÊ¼");  
                for(int i :path)  
                    System.out.print(i+",");  
                System.out.print(root.value);  
            }  
        }  
        else{  
            path.push(root.value);  
            findPath(root.leftNode,k-root.value,path);  
            findPath(root.rightNode,k-root.value,path);  
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
        E25PathInTree e25 = new E25PathInTree();
        e25.findPath(root1, 22);
    }  
}
