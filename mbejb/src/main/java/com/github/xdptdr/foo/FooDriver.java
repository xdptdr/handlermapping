package com.github.xdptdr.foo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class FooDriver implements Driver {

	private Connection fooConnection = new FooConnection();
	private boolean fooBoolean;
	private DriverPropertyInfo[] fooDriverPropertyInfo;
	private int fooMajorVersion;
	private int fooMinorVersion;
	private boolean fooJDBCCompliant;
	private Logger fooLogger;

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return fooConnection;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return fooBoolean;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return fooDriverPropertyInfo;
	}

	@Override
	public int getMajorVersion() {
		return fooMajorVersion;
	}

	@Override
	public int getMinorVersion() {
		return fooMinorVersion;
	}

	@Override
	public boolean jdbcCompliant() {
		return fooJDBCCompliant;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return fooLogger;
	}

}
