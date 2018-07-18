package com.chap04.offer10;

public class Solution2 {

	//给输入的str字符串中的字符进行全排列
	public void permutation(String str){
		if(str == null){ //如果字符串为空，直接返回
			return ;
		}
		permutation(str.toCharArray(), 0); //否则将字符串转换为字符数字，并从字符0位置开始进行全排列
	}

	private void permutation(char[] chars, int pos) {
		if(pos == chars.length - 1){ //只剩最后一个字符时为出口
			System.out.println(chars);
		}
		for(int i = pos; i < chars.length; i++){
			//首部字符和它后面的字符（包括自己）进行交换
			char temp = chars[i];
			chars[i] = chars[pos];
			chars[pos] = temp;
			//递归求后面的字符的排列
			permutation(chars, pos+1);
			//由于前面交换了一下，所以chs的内容改变了，我们要还原回来
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
