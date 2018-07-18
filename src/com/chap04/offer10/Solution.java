package com.chap04.offer10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/**
 * DFS
 * @author Peter
 *
 */
public class Solution {
	private char[] seqs;
	private Integer[] book;
	// ���ڽ��ȥ��
	private HashSet<String> result = new HashSet<String>();

	/**
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С� ���������ַ���abc,���ӡ�����ַ�a,b,c
	 * �������г����������ַ���abc,acb,bac,bca,cab��cba�� ����밴��ĸ˳�������
	 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��\
	 * 
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> arrange = new ArrayList<String>();
		if (str == null || str.isEmpty())
			return arrange;
		char[] strs = str.toCharArray();
		seqs = new char[strs.length];
		book = new Integer[strs.length];
		for (int i = 0; i < book.length; i++) {
			book[i] = 0;
		}
		dfs(strs, 0);
		arrange.addAll(result);
		Collections.sort(arrange);
		return arrange;
	}

	/**
	 * ��ȱ�����
	 */
	private void dfs(char[] arrs, int step) {
		// �������п��� ��¼����
		if (arrs.length == step) {
			String str = "";
			for (int i = 0; i < seqs.length; i++) {
				str += seqs[i];
			}
			result.add(str);
			return; // ������һ��
		}
		// ������������,����ÿһ�ֿ���
		for (int i = 0; i < arrs.length; i++) {
			// �Ƿ��߹�
			if (book[i] == 0) {
				seqs[step] = arrs[i];
				book[i] = 1;
				// ��һ��
				dfs(arrs, step + 1);
				// �������һ�� ����һ��
				book[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s1 = new Solution();
		ArrayList<String> list = s1.Permutation("abc");
		for(String str : list){
			System.out.println(str);
		}
	}
}
