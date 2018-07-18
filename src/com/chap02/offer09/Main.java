package com.chap02.offer09;
//������̨������
public class Main {

	//���ڵݹ�ʵ��
	public long jumpStep(int n){
		if(n < 1){ //û��̨�׷���0
			return 0;
		}
		if(n == 1){ //һ��̨��һ������
			return 1;
		}
		if(n == 2){ //����̨����������
			return 2;
		}
		return jumpStep(n-1) + jumpStep(n-2); //n��̨��f(n-1)+f(n-2)������
	}
	
	//����forѭ��ʵ��
	public long jumpStepByFor(int n){
		int result[] = {0, 1, 2};
		if(n < 3){
			return result[n];
		}
		long jumpCount1 = 1;
		long jumpCount2 = 2;
		long jumpCountn = 0;
		for (int i = 3; i <= n; ++i) {
			jumpCountn = jumpCount1 + jumpCount2;
			jumpCount1 = jumpCount2;
			jumpCount2 = jumpCountn;
		}
		return jumpCountn;
	}
	
	public long jump(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		return 2*jump(n-1);
	}
	public long jumpByFor(int n){
		int result[] = {0, 1, 2};
		if(n < 3){
			return result[n];
		}
		long jumpCount1 = 2;
		long jumpCountn = 0;
		for (int i = 3; i <= n; i++) {
			jumpCountn = 2 * jumpCount1;
			jumpCount1 = jumpCountn;
		}
		return jumpCountn;
	}
	public static void main(String[] args) {
		Main m1 = new Main();
		System.out.println(m1.jumpStep(0));
		System.out.println(m1.jumpStepByFor(0));
		System.out.println(m1.jump(10));
		System.out.println(m1.jumpByFor(10));
	}
}
