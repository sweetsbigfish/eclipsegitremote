package cn.jbit.epet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.epet.dao.BaseDao;
import cn.jbit.epet.dao.MasterDao;
import cn.jbit.epet.entity.Master;

/**
 * MasterDao针对MySQL数据库的实现类。
 */
public class MasterDaoMySQLImpl extends BaseDao implements MasterDao {

	@Override
	public int del(Master master) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Master master) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Master master) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Master findMaster(Master mas) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Master master = null;
		try {
			conn = this.getConnection();
			String sql = "select * from master where  name = ? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mas.getName());
			pstmt.setString(2, mas.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				master = new Master();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return master;
	}
}
