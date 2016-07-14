package core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import next.model.User;

public abstract class JdbcTemplate {
	
	public void update(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = this.createQuery();
			pstmt = con.prepareStatement(sql);
			this.setValue(user, pstmt);
			
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			
			if (con != null) {
				con.close();
			}
		}
	}

	public abstract void setValue(User user, PreparedStatement pstmt) throws SQLException;

	public abstract String createQuery();
	
}
