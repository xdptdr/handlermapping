package com.github.xdptdr.mbejb;

import java.sql.Connection;
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
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Connection getH2Connection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:mem:test");
	}

	@Override
	public Connection getMysqlConnection() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/foobar?user=foobar&password=foobar&&serverTimezone=UTC");
	}

	@Override
	public Connection getSqlServerConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=foobar;password=foobar;userName=foobar;"
);
	}

	@Override
	public Connection getPostgresqlConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql:foobar", "foobar", "foobar");
	}

}
