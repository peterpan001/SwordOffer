package com.chap04.offer11;

//�˻ʺ�����
public class Solution {

	/**
	 * һ���ж��ٸ��ʺ󣨴�ʱ����Ϊ8�ʺ���8X8���̣������޸Ĵ�ֵ������N�ʺ����⣩
	 */
	int max = 8;
	/**
	 * �����鱣��������һ���ʺ����array[0]�У��ڶ�������array[1]��
	 */
	int[] array = new int[max];

	/**
	 * ��¼�ڷ�����
	 */
	private static int count = 0;
	
	/**
	 * n����ǰ�ǵڼ����ʺ�
	 * @param n
	 * �ʺ�n��array[n]��
	 */
	private void check(int n) {
		// ��ֹ���������һ���Ѿ����꣬����ÿ��һ������У���Ƿ��г�ͻ������ֻҪ���һ�а��꣬˵���Ѿ��õ���һ����ȷ��
		if (n == max) {
			print();
			++count;
			return;
		}
		// �ӵ�һ�п�ʼ��ֵ��Ȼ���ж��Ƿ�ͱ��б��б�б���г�ͻ�����OK���ͽ�����һ�е��߼�
		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	//�ж��Ƿ���ͬһ�У�ͬһ�Խ����ϣ��ǵĻ�������������
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//��ӡ�ʺ�ڷ�����
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + 1 + " ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		Solution s1 = new Solution();
		s1.check(0);
		System.out.println(count);
	}

}
