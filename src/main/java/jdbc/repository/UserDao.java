package jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserDao {
	// 1. 資料庫放置位置
	private String db_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/db/";
	// 2. 資料庫名稱
	private String db_name = "webdb.db";
	// 3. 建立資料庫連線參數
	private String db_url = "jdbc:sqlite:" + db_path + db_name;
			
	// 建立 DB
	public void createDB() throws Exception {
		// 4. 建立資料庫 Driver
		Class.forName("org.sqlite.JDBC");
		// 5. 建立資料庫連線物件
		Connection conn = DriverManager.getConnection(db_url);
		if(!conn.isClosed()) {
			System.out.println("資料庫建立/連線成功");
		}
		conn.close();
	}
	
	private Connection getConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(db_url);
		return conn;
	}
	
	// 建立資料表 Table
	public void createTable() throws Exception {
		String sql = "create table if not exists user("
					+ "id integer primary key, "
					+ "username text not null, "
					+ "password text not null, "
					+ "createtime datetime default current_timestamp"
					+ ")";
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("user 資料表建立完成 !");
	}
	
	public static void main(String[] args) throws Exception {
		new UserDao().createTable();
	}
	
}
