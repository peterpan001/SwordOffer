package com.chap04.offer10;

public class Main {
	/** 1������Ԫ�ص�ȫ��� */
	public void combination(char[] chars) {
		char[] subchars = new char[chars.length]; // �洢��������ݵ�����
		// ȫ��������������Ԫ��(��Ϊn)��ѡ1��Ԫ�ص����, ����ѡ2��Ԫ�ص����...����ѡn��Ԫ�ص���ϵĺ�
		for (int i = 0; i < chars.length; ++i) {
			final int m = i + 1;
			combination(chars, chars.length, m, subchars, m);
		}
	}

	/**
	 * n��Ԫ��ѡm��Ԫ�ص���������ʵ��. ԭ������: �Ӻ���ǰѡȡ, ѡ��λ��i��, ����ǰi-1������ѡȡm-1��. ��: 1, 2, 3, 4,
	 * 5 ��ѡȡ3��Ԫ��. 1) ѡȡ5��, ����ǰ4������ѡȡ2��, ��ǰ4������ѡȡ2������һ��������, �ݹ鼴��; 2) ���������5,
	 * ֱ��ѡ��4, ��ô����ǰ3������ѡȡ2��, ��ǰ��������ѡȡ2������һ��������, �ݹ鼴��; 3) ���Ҳ������4, ֱ��ѡȡ3,
	 * ��ô����ǰ2������ѡȡ2��, �պ�ֻ������. ����, 1��2��3�պ���һ��forѭ��, ��ֵΪ5, ��ֵΪm. ����,
	 * ������Ϊһ��ǰi-1����ѡm-1�ĵݹ�.
	 */
	public void combination(char[] chars, int n, int m, char[] subchars,
			int subn) {
		if (m == 0) { // ����
			for (int i = 0; i < subn; ++i) {
				System.out.print(subchars[i]);
			}
			System.out.println();
		} else {
			for (int i = n; i >= m; --i) { // �Ӻ���ǰ����ѡ��һ��
				subchars[m - 1] = chars[i - 1]; // ѡ��һ����
				combination(chars, i - 1, m - 1, subchars, subn); // ��ǰi-1������ѡȡm-1�����еݹ�
			}
		}
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		char []chars = {'a', 'b', 'c'};
		m1.combination(chars);
	}
}
