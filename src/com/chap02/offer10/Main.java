package com.chap02.offer10;
// ���ǵذ�����
public class Main {

	//���ڵݹ�ʵ��
	public long pavingFloor(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){ //��2*1�ĵذ�
			return 1;
		}
		if(n==2){ //��2*2�ĵذ�
			return 2;
		}
		
		return pavingFloor(n-1) + pavingFloor(n-2); //��2*n�ĵذ�
	}
	
	//����forѭ��ʵ��
	public long pavingFloorByFor(int n){
		int result[] = {0, 1, 2};
		if(n < 3){
			return result[n];
		}
		int pavingCount1 = 1;
		int pavingCount2 = 2;
		int pavingN = 0;
		for (int i = 3; i <= n; i++) {
			pavingN = pavingCount1 + pavingCount2;
			pavingCount1 = pavingCount2;
			pavingCount2 = pavingN;
		}
		return pavingN;
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		System.out.println(m1.pavingFloor(5));
		System.out.println(m1.pavingFloorByFor(5));
	}
}
