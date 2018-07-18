package com.chap04.offer07;

import java.util.ArrayList;
import java.util.Stack;
//�������к�Ϊĳһֵ��·��
public class Main1 {

	
	public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode pRoot, int expectedSum){
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){ //�������Ϊ����ֱ�ӷ���
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();//����ջ���洢һ��·��
		findPath(pRoot, expectedSum, path, pathList); //���ò��ҷ���
 		return pathList;
	}

	private void findPath(BinaryTreeNode pRoot, int expectedSum,
			Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
		if(pRoot == null){
			return;
		}
		//�ж����ǲ���Ҷ�ӽ�㣬����ǿ����ǲ��ǵ�������ֵ���ǵĻ�ֱ����ӵ�ArrayList���ϵ���
		if(pRoot.leftNode == null && pRoot.rightNode == null){
			if(pRoot.value == expectedSum){ //�����������ֵ������ӵ�list������
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int value : path) {
					list.add(value);
				}
				list.add(pRoot.value);
				pathList.add(list);
			}
		}else{
			//����Ҷ�ӽ�㣬ǰ�����������ǰ���ֵ����pathջ��
			path.push(pRoot.value);
			findPath(pRoot.leftNode, expectedSum - pRoot.value, path, pathList);
			findPath(pRoot.rightNode, expectedSum - pRoot.value, path, pathList);
			//�ڷ��ص������֮ǰ����·����ɾ����ǰ����ֵ
			path.pop();
		}
		
	}
	
}
