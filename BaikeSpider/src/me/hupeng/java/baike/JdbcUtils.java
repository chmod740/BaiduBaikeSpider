package me.hupeng.java.baike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtils {
	private JdbcUtils(){
	}
	
	private static String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String user = "BAIKE";
	private static String password = "31415926";
	private static Connection connection=null;
	private static PreparedStatement preparedStatement=null;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
		try {
			connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return connection;
	}
	
	public static void free (ResultSet resultSet , Statement statement , Connection connection){
		try{
			if (resultSet!=null) {
				resultSet.close();
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}finally{
			try{
				if (statement!=null) {
					statement.close();
				}
			}catch (SQLException e) {
				// TODO: handle exception
			}finally{
				if (connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
