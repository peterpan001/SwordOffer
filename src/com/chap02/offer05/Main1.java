package com.chap02.offer05;
/**
 * 由中序和后序构建二叉树
 * @author Peter
 *
 */
public class Main1 {

	public static TreeNode rebuildBinaryTree(int []postorder, int []inorder){
		if(postorder == null || inorder == null){
			return null;
		}
		TreeNode root = rebuildBinaryTreeCore(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
		return root;
	}
	
	public static TreeNode rebuildBinaryTreeCore(int []postorder, int startPostorder, int endPostorder, int []inorder, int startInorder, int endInorder){
		
		if(startPostorder > endPostorder || startInorder > endInorder){ //终止递归的条件
			return null;
		}
		TreeNode root = new TreeNode(postorder[endPostorder]);
		for (int i = startInorder; i <= endInorder; i++) {
			if(inorder[i] == postorder[endPostorder]){
				root.left = rebuildBinaryTreeCore(postorder, startPostorder, startPostorder -1 + (i - startInorder), inorder, startInorder, i-1);
				root.right = rebuildBinaryTreeCore(postorder, startPostorder + (i - startInorder), endPostorder-1, inorder, i+1, endInorder);
			}
		}
		return root;
	}
	
	/*
	 *  后序：2  4  3  1          6    7    5
	 *  中序：1  2  3  4     5    6    7
	 *              5     
	 *       1           7
	 *           3     6  
	 *         2   4   
	 */
	public static void main(String[] args) {
		int []inorder = {1, 2, 3, 4, 5, 6, 7};
		int []postorder = {2, 4, 3, 1, 6, 7, 5};
		TreeNode treeNode = rebuildBinaryTree(postorder, inorder);
		System.out.println(treeNode);
	}
	
}

