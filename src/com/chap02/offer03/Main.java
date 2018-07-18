package com.chap02.offer03;
/**
 * �滻�ո�
 * @author Peter
 *
 */
public class Main {

	public static String replaceBlank(StringBuffer sb){
		int blankCount = 0;
		//��ͳ�Ƴ��ո������
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)== ' '){
				++blankCount;
			}
		}
		int oldLength = sb.length(); //�õ�ԭ���ַ����ĳ���
		int newLength = oldLength + blankCount * 2; //���ո��滻Ϊ"%20"����ַ�����
		int oldIndex = oldLength - 1; //ԭ���ַ���������
		int newIndex = newLength - 1; //���ַ���������
		sb.setLength(newLength);
		//һ�α������滻���еĿո�Ϊ"%20"
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
