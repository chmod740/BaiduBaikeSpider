# BaiduBaikeSpider
百度百科多线程爬虫Java源码，数据存储采用了Oracle11g
# 简介
采用了MyEclipes作为集成开发环境，应该是兼容eclips
# 使用方法
下载此源码之后使用 （导入 或者 import）操作导入此项目
# 各个类介绍
## HtmlDAO.java
主要是进行把爬虫爬回来的数据插入到数据库中的操作。
### JdbcUtil.java
进行数据库的基础操作，获取一个连接操作，释放连接操作
如果要更改数据库需要修改的部分有：
```java
private static String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
private static String user = "BAIKE";
private static String password = "31415926";
Class.forName("oracle.jdbc.driver.OracleDriver");
```
另外别忘了导入数据库对应的Java驱动。
### HttpRequest.java
执行HTTP请求的类，注意，并不支持HTTPS请求，如果要进行HTTPS请求，请使用 https://github.com/imu-hupeng/HttpsRequest/ 项目中的HttpsRequest.java
### IdCreater.java
引入这个类的原因主要是百度百科使用的数字作为索引，好几个爬虫线程协同工作时要保证它们访问的索引即不重复也不丢失，因此需要一个线程同步的索引产生器。
可以在里面修改索引的起始值与结束值。
### WebCrawler.java
实现爬虫功能。
### Main.java
可以修改 THREAD_NUM 的值添加不同数目的爬虫数量。
# 附百科SQL文件322MB:https://github.com/imu-hupeng/BaiduBaikeSpider/releases/download/v1.0.0/BAIKE_HTML.sql
