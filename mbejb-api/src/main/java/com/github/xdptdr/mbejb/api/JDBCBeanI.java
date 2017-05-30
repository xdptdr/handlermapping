package com.github.xdptdr.mbejb.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCBeanI {

	public Connection getH2Connection() throws SQLException;
	public Connection getMysqlConnection() throws SQLException;
	public Connection getSqlServerConnection() throws SQLException;
	public Connection getPostgresqlConnection() throws SQLException;

}
