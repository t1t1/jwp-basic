package core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class JdbcTemplate {
	
	public void update() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = this.createQuery();
			pstmt = con.prepareStatement(sql);
			this.setValue(pstmt);
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

	public abstract void setValue(PreparedStatement pstmt) throws SQLException;

	public abstract String createQuery();
	
}
