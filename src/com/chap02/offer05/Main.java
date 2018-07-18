package com.chap02.offer05;
/**
 * 由前序和中序重建二叉树
 * @author Peter
 */
public class Main {

	public static TreeNode rebuildBinaryTree(int preorder[], int inorder[]) {
		if (preorder == null || inorder == null) {
			return null;
		}

		TreeNode root = rebuildBinaryTreeCore(preorder, 0, preorder.length - 1,
				inorder, 0, inorder.length - 1);
		return root;
	}

	public static TreeNode rebuildBinaryTreeCore(int preorder[], int startPreorder,
			int endPreorder, int inorder[], int startInorder, int endInorder) {
		if (startPreorder > endPreorder || startInorder > endInorder) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[startPreorder]);
		for (int i = startInorder; i <= endInorder; i++) {
			if (preorder[startPreorder] == inorder[i]) {
				//其中（i - startInorder）为中序排序中左子树结点的个数
				root.left = rebuildBinaryTreeCore(preorder, startPreorder + 1, startPreorder + (i - startInorder), inorder, startInorder, i-1);
				root.right = rebuildBinaryTreeCore(preorder, (i - startInorder) + startPreorder + 1, endPreorder, inorder, i + 1, endInorder);

			}

		}
		return root;
	}
	
	public static void main(String[] args) {
		int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
		int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode treeNode = rebuildBinaryTree(preorder, inorder);
		System.out.println(treeNode);
	}
}
/*
	4,7,3数量为3个即i-startInorder
 1    2 4 7        3 5 6 8
      4 7 2    1   5 3 8 6

             1
         2       3
      4        5   6
         7   8
*/