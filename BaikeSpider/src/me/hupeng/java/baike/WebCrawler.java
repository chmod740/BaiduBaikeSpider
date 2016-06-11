package me.hupeng.java.baike;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class WebCrawler extends Thread{
	private HtmlDAO htmlDAO;
	private int threadId;
	
	public WebCrawler(){
		htmlDAO = new HtmlDAO();
		threadId = 0;
	}
	
	public void setThreadId(int threadId){
		this.threadId = threadId;
	}
	
	@Override
	public void run() {
		while(true){
			int id = IdCreater.getId();
			if (id == -1) {
				break;
			}
			try {
				String title = null;
				String content = null;
				String url = "http://baike.baidu.com/view/"+ id	+ ".htm";
				String response = HttpRequest.sendGet(url, "");
				//htmlDAO.insert(i,response);
				//System.out.println(i);
				HtmlCleaner htmlCleaner = new HtmlCleaner();
				TagNode tagNode = htmlCleaner.clean(response);
				Object[] os =  tagNode.evaluateXPath("//div[@class='lemma-summary']");
				
				TagNode[] titles  = tagNode.getElementsByName("title", true);
				//System.out.println("title="+((TagNode)titles[0]).getText());
				title = ((TagNode)titles[0]).getText().toString();
				
				//System.out.println(os.length);
				if(os.length != 0){
					for (Object obja : os) {  
		                TagNode tna = (TagNode) obja;  
		                String str = tna.getText().toString();  
		                content = str;
		               // System.out.println(str);
		            }  
				}
				if (content != null && title != null && !title.equals("百度百科——全球最大中文百科全书")) {
					title = title.replaceAll("_百度百科", "");
					System.out.println("id=" + id);
//					System.out.println("title=" + title);
//					System.out.println("content=" + content);
					System.out.println("thread=" + threadId);
					System.out.println("=========================================================");
					htmlDAO.insert(id, content, title);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}
