package me.hupeng.java.baike;

public class IdCreater {
	//1010000
	private static int MIN_VALUE = 0;
	private static int MAX_VALUE = 1010000;
	private static int NOW_VALUE;
	
	static{
		NOW_VALUE = MIN_VALUE;
	}
	
	synchronized public static int getId(){
		if (NOW_VALUE < MAX_VALUE ) {
			return NOW_VALUE ++;
		}else {
			return -1;
		}
	}
}
