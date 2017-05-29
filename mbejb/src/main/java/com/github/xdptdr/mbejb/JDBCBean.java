package com.github.xdptdr.mbejb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.ejb.Singleton;

import com.github.xdptdr.mbejb.api.JDBCBeanI;

@Singleton
@Local(JDBCBeanI.class)
public class JDBCBean implements JDBCBeanI {

	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DatabaseMetaData getDatabaseMetaData() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:h2:mem:test");
		return con.getMetaData();
	}

}
