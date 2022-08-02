package jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.Statement;
import java.util.Base64;

import jdbc.entity.User;

public class UserDao {
	// 1. 資料庫放置位置
	private String db_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/db/";
	// 2. 資料庫名稱
	private String db_name = "webdb.db";
	// 3. 建立資料庫連線參數
	private String db_url = "jdbc:sqlite:" + db_path + db_name;
	
	// 取得 Connection 物件
	private Connection getConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(db_url);
		return conn;
	}
		
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
	
	// 新增 user 資料列
	public int add(User user) {
		String sql = "insert into user(username, password) values(?, ?)";
		int rowcount = 0;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	
	public static void main(String[] args) throws Exception {
		//new UserDao().createDB();
		//new UserDao().createTable();
		String password = "1234";
		new UserDao().add(new User("john", Base64.getEncoder().encodeToString(password.getBytes())));
		password = "5678";
		new UserDao().add(new User("mary", Base64.getEncoder().encodeToString(password.getBytes())));
		
	}
	
}
