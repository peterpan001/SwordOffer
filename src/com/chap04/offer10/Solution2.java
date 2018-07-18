package com.chap04.offer10;

public class Solution2 {

	//�������str�ַ����е��ַ�����ȫ����
	public void permutation(String str){
		if(str == null){ //����ַ���Ϊ�գ�ֱ�ӷ���
			return ;
		}
		permutation(str.toCharArray(), 0); //�����ַ���ת��Ϊ�ַ����֣������ַ�0λ�ÿ�ʼ����ȫ����
	}

	private void permutation(char[] chars, int pos) {
		if(pos == chars.length - 1){ //ֻʣ���һ���ַ�ʱΪ����
			System.out.println(chars);
		}
		for(int i = pos; i < chars.length; i++){
			//�ײ��ַ�����������ַ��������Լ������н���
			char temp = chars[i];
			chars[i] = chars[pos];
			chars[pos] = temp;
			//�ݹ��������ַ�������
			permutation(chars, pos+1);
			//����ǰ�潻����һ�£�����chs�����ݸı��ˣ�����Ҫ��ԭ����
			temp = chars[i];
			chars[i] = chars[pos];
			chars[pos] = temp;
		}
		
	}
	
	public static void main(String[] args) {
		Solution2 m1 = new Solution2();
		m1.permutation("abc");
	}
}
