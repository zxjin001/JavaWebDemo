package com.mapeak.smis.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidUtil {
	private static DataSource ds = null;
	
	static {
		// 当 JdbcUtil 这份字节码被加载进 JVM 就立即执行，且只执行一次
		try {
			Properties p = new Properties();
			// 加载和读取 db.properties 文件
			InputStream inStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("druid.properties");
			p.load(inStream);
			
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			//从连接池中获取 Connection 对象
			return ds.getConnection();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}
