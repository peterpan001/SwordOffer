package com.chap02.offer02;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		int array[][] = new int[3][4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 3; i++){
			for(int j = 0 ; j < 4; j++){
				array[i][j] = sc.nextInt();
			}
		}		
		int target = sc.nextInt();
		Main m1 = new Main();
		System.out.println(m1.find1(array, target));
	}
}
