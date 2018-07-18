package com.chap03.offer08;
//�����ӽṹ
public class Main {

	public boolean HasSubtree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
		boolean result = false;
		if(pRoot1!=null && pRoot2!=null){
			if(pRoot1.data == pRoot2.data){
				result = DoesTree1HaveTree2(pRoot1, pRoot2);
			}
			if(!result){
				result = HasSubtree(pRoot1.left, pRoot2);
			}
			if(!result){
				result = HasSubtree(pRoot1.right, pRoot2);
			}
		}
		return result;
	}

	//�ж������ĳ����������Ľ���Ƿ���ͬ
	private boolean DoesTree1HaveTree2(BinaryTreeNode pRoot1,
			BinaryTreeNode pRoot2) {
		if(pRoot2 == null){
			return true;
		}
		if(pRoot1==null){
			return false;
		}
		if(pRoot1.data != pRoot2.data){
			return false;
		}
		return DoesTree1HaveTree2(pRoot1.left, pRoot2.left) && DoesTree1HaveTree2(pRoot1.right, pRoot2.right);
	}
}
