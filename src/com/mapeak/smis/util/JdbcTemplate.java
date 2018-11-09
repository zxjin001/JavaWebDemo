package com.mapeak.smis.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.smis.handler.IResultSetHandler;

// JDBC ������ģ����
public class JdbcTemplate {
	public static <T>T query(String sql, 
			IResultSetHandler<T> handler, Object... params) {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try{
			conn = DruidUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {
				//setObject �������ò���ֵ
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			//������������ÿһ�����ݷ�װ��һ������
			return handler.handle(rs);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DruidUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	public static int update(String sql, Object ...params) {
		Connection conn = null;
		PreparedStatement ps= null;
		try{
			conn = DruidUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {
				//setObject �������ò���ֵ
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DruidUtil.close(conn, ps, null);
		}
		return 0;
	}
}
