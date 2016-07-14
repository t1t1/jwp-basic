package core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import next.dao.UserDao;
import next.model.User;

public abstract class InsertjdbcTemplate {
	
	public void insert(User user, UserDao userDao) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionManager.getConnection();
//			String sql = userDao.createQueryForInsert();
			String sql = this.createQueryForInsert();
			pstmt = con.prepareStatement(sql);
//			userDao.setValueForInsert(user, pstmt);
			this.setValueForInsert(user, pstmt);

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
	
	public abstract void setValueForInsert(User user, PreparedStatement pstmt) throws SQLException;

	public abstract String createQueryForInsert();
	
}
