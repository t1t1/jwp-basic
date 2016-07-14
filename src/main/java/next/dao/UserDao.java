package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import next.model.User;
import core.jdbc.ConnectionManager;
import core.jdbc.JdbcTemplate;

public class UserDao {
	
	public void insert(User user) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate() {
			@Override
//			public void setValue(User user, PreparedStatement pstmt)
			public void setValue(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getEmail());
			}
		};
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql);
	}
	
	public void update(User user) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate() {
			
			@Override
//			public void setValue(User user, PreparedStatement pstmt)
			public void setValue(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getUserId());
			}
		};
		String sql = "UPDATE USERS"
				+ " SET"
				+ " password = ?"
				+ ", name = ?"
				+ ", email = ?"
				+ " WHERE userid = ?";
		jdbcTemplate.update(sql);
	}
	
	public List<Object> findAll() throws SQLException {
		List<Object> users = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = setSql();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			users = (List<Object>)getList(rs);
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			
			if (con != null) {
				con.close();
			}
		}
		return users;
	}

	private List<Object> getList(ResultSet rs) throws SQLException {
		List<Object> list = new ArrayList<>();
		while (rs.next()) {
			String userId = rs.getString("userid");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String email = rs.getString("email");
			User user = new User(userId, password, name, email);
			list.add(user);
		}
		return list;
	}

	private String setSql() {
		String sql = "SELECT * FROM USERS";
		return sql;
	}

	public User findByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				user = new User(
						rs.getString("userId"), 
						rs.getString("password"), 
						rs.getString("name"),
						rs.getString("email"));
			}

			return user;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
