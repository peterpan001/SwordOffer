package com.chap02.offer01;
//µ¥Àý
public class Singleton {

	private Singleton(){}
	
	private static class SingletonHolder{
		private static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance(){
		return SingletonHolder.instance;
	}
}
