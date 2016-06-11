package me.hupeng.java.baike;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class Main {
	public static final int THREAD_NUM = 4;
	
	public static void main(String[] args) {
		WebCrawler[] webCrawlers = new WebCrawler[THREAD_NUM];
		
		for(int i = 0 ; i < THREAD_NUM ; i++){
			webCrawlers[i] = new WebCrawler();
			webCrawlers[i].setThreadId(i);
			webCrawlers[i].start();
		}
	}
}
