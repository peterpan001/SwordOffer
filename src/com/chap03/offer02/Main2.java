package com.chap03.offer02;

//�����������
public class Main2 {

	// �����������
	public char[] addStrNums(String str1, String str2) {
		char[] num1 = str1.toCharArray(); // ���ַ���1ת��Ϊ�ַ�����1
		char[] num2 = str2.toCharArray(); // ���ַ���2ת��Ϊ�ַ�����2
		int nTakeOver = 0; // ��λ������
		boolean flag = false; // �жϽ��������ʶ,��������Ϊtrue������Ϊfalse
		char num[] = null;
		int nsum = 0;
		// һ����+һ����
		if ((num1[0] == '-' && num2[0] != '-')
				|| (num1[0] != '-' && num2[0] == '-')) {
			if (num1[0] == '-' && num2[0] != '-') { // num1Ϊ�����ַ�����num2Ϊ�����ַ���
				num1 = numsAbs(num1);
				num2 = numsAbs(num2);
				if (getMaxAbs(num2, num1)) { // num2>num1,���Ϊ����
					char temp[] = num1;
					num1 = num2;
					num2 = temp;
					flag = false;
				} else { // ������Ϊ����
					flag = true;
				}
			} else {
				num1 = numsAbs(num1);
				num2 = numsAbs(num2);
				if (getMaxAbs(num2, num1)) { // num2>num1,���Ϊ����
					flag = true;
					char temp[] = num1;
					num1 = num2;
					num2 = temp;
				} else { // ������Ϊ����
					flag = false;
				}
			}
			num = new char[num1.length];
			for (int i = num1.length - 1, j = num2.length - 1; i >= 0; --i, --j) {
				if (j >= 0) {
					nsum = num1[i] - num2[j] + nTakeOver;
					if (nsum < 0) {
						// ������С��0 ���Ͻ�һλ
						nTakeOver = -1;
						nsum = nsum + 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				} else {
					nsum = num1[i] + nTakeOver - '0';
					if (nsum < 0) {
						nTakeOver = -1;
						nsum = nsum + 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				}
			}
		} else { // ����������ӻ��������������
			if ((num1[0] == '-' && num2[0] == '-')) {
				num1 = numsAbs(num1);
				num2 = numsAbs(num2);
				flag = true; // ���Ϊ����
			}else{
				num1 = numsAbs(num1);
				num2 = numsAbs(num2);
				flag = false; //���Ϊ����
			}
			if (getMaxAbs(num2, num1)) { // ���num1����num2����λ��
				char temp[] = num1;
				num1 = num2;
				num2 = temp;
			}
			num = new char[num1.length];
			for (int i = num1.length - 1, j = num2.length - 1; i >= 0; --i, --j) {
				if (j >= 0) {
					nsum = num1[i] - '0' + num2[j] - '0' + nTakeOver;
					if (nsum >= 10) {
						// ��Ӵ��ڵ���ʮ ������λ
						nTakeOver = 1;
						nsum = nsum - 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				} else {
					nsum = num1[i] - '0' + nTakeOver;
					if (nsum >= 10) {
						nTakeOver = 1;
						nsum = nsum - 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				}
			}
		}
		if(flag){ //���Ϊ����
			char []temp = new char[num.length + 1];
			temp[0] = '-';
			for (int i = 0; i < num.length; i++) {  
                temp[i + 1] = num[i];  
            }
            return temp;
		}else{
			return num;
		}
	}

	//��ӡ����������ӵĽ��
	private void printNumber(char[] number) {
		boolean isBeginning0=true;  
		boolean isJudge0 = true;
        //�����һ���ַ�Ϊ'-'���ȴ�ӡ�����ַ� Ȼ��i��1��ʼ�������ַ��������ӵ�һ����0�ַ���ʼ��ӡ���ַ�����  
        int i=0;  
        if(number[0]=='-')   
        {  
            System.out.print(number[0]);
            ++i;
        }  
        for(; i<number.length;i++){  
            if(isBeginning0 && number[i]!='0'){  
                break;  
            }  
        }  
        for(; i<number.length;i++){  
            System.out.print(number[i]);  
        }
        for (int j = 0; j < number.length; j++) {
			if(number[j] != '0'){
				isJudge0 = false;
				break;
			}
		}
        if(isJudge0){
        	System.out.print(0);
        }
        System.out.println();
	}
	
	// �ж����������ַ����ľ���ֵ��С
	public boolean getMaxAbs(char num1[], char num2[]) {
		num1 = numsAbs(num1);
		num2 = numsAbs(num2);
		int len1 = num1.length;
		int len2 = num2.length;
		if (len1 > len2) { // ���num1���ȴ���num2���򷵻�true
			return true;
		} else if (len1 < len2) { // ���num1����С��num2���򷵻�false
			return false;
		} else {
			for (int i = 0; i < len1; i++) { // ���num1���ȵ���num2���ȣ���ʼһ��һ���ַ����бȽ�
				if (num1[i] > num2[i]) { // num1�󣬷���true
					return true;
				} else if (num1[i] < num2[i]) { // num2�󣬷���false�����������һλ�Ƚ�
					return false;
				}
			}
		}
		return true;
	}

	// ȡһ�������ַ������ľ���ֵ
	public char[] numsAbs(char[] nums) {
		if (nums[0] != '-' && nums[0] != '+') { // ����ַ�����ĵ�һλ����'-'ֱ�ӷ���
			return nums;
		}
		char temp[] = new char[nums.length - 1];
		for (int i = 0; i < temp.length; ++i) {
			temp[i] = nums[i + 1];
		}
		return temp;
	}

	public static void main(String[] args) {
		Main2 m2 = new Main2();
		char[] nums = m2.addStrNums("0", "0");
		m2.printNumber(nums);
		
		char[] nums1 = m2.addStrNums("+123", "+123");
		m2.printNumber(nums1);
		
		char[] nums2 = m2.addStrNums("-123", "-123");
		m2.printNumber(nums2);
		
		char[] nums3 = m2.addStrNums("-123", "+123");
		m2.printNumber(nums3);
	}
}
