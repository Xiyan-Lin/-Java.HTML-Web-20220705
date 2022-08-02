package jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
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
	
	
	// 修改 user username 資料列
	public int updateUsername(Integer id, String username) {
		String sql = "update user set username=? where id=?";
		int rowcount = 0;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setInt(2, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改 user password 資料列
	public int updatePassword(Integer id, String password) {
		String sql = "update user set password=? where id=?";
		int rowcount = 0;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改 user 資料列
	public int update(Integer id, User user) {
		String sql = "update user set username=?, password=? where id=?";
		int rowcount = 0;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 刪除 user 資料列
	public int delete(Integer id) {
		String sql = "delete from user where id=?";
		int rowcount = 0;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setInt(1, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// get user 資料列
	public User getUser(Integer id) {
		String sql = "select id, username, password, createtime from user where id = ?";
		User user = null;
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreatetime(rs.getDate("createtime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void main(String[] args) throws Exception {
		//new UserDao().createDB();
		//new UserDao().createTable();
		//String password = "1234";
		//new UserDao().add(new User("john", Base64.getEncoder().encodeToString(password.getBytes())));
		//password = "5678";
		//new UserDao().add(new User("mary", Base64.getEncoder().encodeToString(password.getBytes())));
		//int rowcount = new UserDao().updateUsername(1, "John");
		//int rowcount = new UserDao().updatePassword(1, Base64.getEncoder().encodeToString("abcd".getBytes()));
		//User user = new User("Tom", Base64.getEncoder().encodeToString("1234".getBytes()));
		//int rowcount = new UserDao().update(1, user);
		//int rowcount = new UserDao().delete(3);
		//System.out.println(rowcount);
		System.out.println(new UserDao().getUser(1));
		
	}
	
}
