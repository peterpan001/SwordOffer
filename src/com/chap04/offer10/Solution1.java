package com.chap04.offer10;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();

		if (str != null && str.length() > 0) {
			char[] seq = str.toCharArray();
			Arrays.sort(seq); // ����
			res.add(String.valueOf(seq)); // �����һ����

			int len = seq.length;
			while (true) {
				int p = len - 1, q;
				// �Ӻ���ǰ��һ��seq[p - 1] < seq[p]
				while (p >= 1 && seq[p - 1] >= seq[p])
					--p;
				if (p == 0)
					break; // �Ѿ��ǡ���С�������У��˳�
				// ��p��������һ����seq[p]�����
				q = p;
				--p;
				while (q < len && seq[q] > seq[p])
					q++;
				--q;
				// ����������λ���ϵ�ֵ
				swap(seq, q, p);
				// ��p֮������е�������
				reverse(seq, p + 1);
				res.add(String.valueOf(seq));
			}
		}

		return res;
	}

	public static void reverse(char[] seq, int start) {
		int len;
		if (seq == null || (len = seq.length) <= start)
			return;
		for (int i = 0; i < ((len - start) >> 1); i++) {
			int p = start + i, q = len - 1 - i;
			if (p != q)
				swap(seq, p, q);
		}
	}

	public static void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}
}
