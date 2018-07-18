package com.chap03.offer08;
//树的子结构
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

	//判断子树的除根结点以外的结点是否相同
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
