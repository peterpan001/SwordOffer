package com.chap02.offer03;
/**
 * 替换空格
 * @author Peter
 *
 */
public class Main {

	public static String replaceBlank(StringBuffer sb){
		int blankCount = 0;
		//先统计出空格的数量
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)== ' '){
				++blankCount;
			}
		}
		int oldLength = sb.length(); //得到原来字符串的长度
		int newLength = oldLength + blankCount * 2; //将空格替换为"%20"后的字符长度
		int oldIndex = oldLength - 1; //原来字符串的索引
		int newIndex = newLength - 1; //新字符串的索引
		sb.setLength(newLength);
		//一次遍历，替换其中的空格为"%20"
		while(oldIndex >= 0 && newIndex > oldIndex){
			if(sb.charAt(oldIndex)== ' '){
				sb.setCharAt(newIndex--, '0');
				sb.setCharAt(newIndex--, '2');
				sb.setCharAt(newIndex--, '%');
			}else{
				sb.setCharAt(newIndex--, sb.charAt(oldIndex));
			}
			--oldIndex;
		}
		return sb.toString();
	}
	
	public static String replaceBlank1(StringBuffer sb){
		for (int i = 0; i < sb.length(); i++) {
			char ch1 = sb.charAt(i);
			if(ch1 == ' '){
				sb.replace(i, i+1, "%20");
			}
		}
		
		return sb.toString();
	}
	
	public static String replaceBlank2(String str){
		String str1 = str.replaceAll(" ", "%20");
		return str1;
	}
	
	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("We are happy.");
//		String str = replaceBlank1(sb);
//		System.out.println(str);
		
		String string1 = "We are happy.";
		String str1 = replaceBlank2(string1);
		System.out.println(str1);
	}
	
	
}
