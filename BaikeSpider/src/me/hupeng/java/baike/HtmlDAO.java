package me.hupeng.java.baike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HtmlDAO {
	Connection connection;
	public HtmlDAO(){
		try {
			connection = JdbcUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public void insert(Integer id,String content,String title){
		String sql = "insert into BAIKE_HTML (ID,HTML_CONTENT,HTML_TITLE) values (?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, title);
			int result =  preparedStatement.executeUpdate();
			if (result>0) {
				//return true;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
