package com.github.xdptdr.foo;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class FooConnection implements Connection {

	private boolean fooIsWrapper;
	private Statement fooStatement = new FooStatement();
	private PreparedStatement fooPreparedStatement = new FooPreparedStatement();
	private CallableStatement fooCallableStatement = new FooCallableStatement();
	private String fooNativeSQL;
	private boolean fooAutoCommit;
	private boolean fooIsClosed;
	private DatabaseMetaData fooDatabaseMetaData = new FooDatabaseMetaData();
	private boolean fooIsReadOnly;
	private String fooCatalog;
	private int fooTransactionIsolation;
	private SQLWarning fooSQLWarning;
	private Map<String, Class<?>> fooMapStringClass;
	private int fooHoldability;
	private Savepoint fooSavepoint;
	private Clob fooClob = new FooClob();
	private Blob fooBlob = new FooBlob();
	private NClob fooNClob= new FooNClob();
	private SQLXML fooSQLXML= new FooSQLXML();
	private boolean fooValid;
	private String fooClientInfo;
	private Properties fooProperties;
	private Array fooArray;
	private Struct fooStruct = new FooStruct();
	private String fooSchema;
	private int fooNetworkTimeout;

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		try {
			return iface.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return fooIsWrapper;
	}

	@Override
	public Statement createStatement() throws SQLException {
		return fooStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		return fooCallableStatement;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		return fooNativeSQL;
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {

	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return fooAutoCommit;
	}

	@Override
	public void commit() throws SQLException {

	}

	@Override
	public void rollback() throws SQLException {

	}

	@Override
	public void close() throws SQLException {

	}

	@Override
	public boolean isClosed() throws SQLException {
		return fooIsClosed;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return fooDatabaseMetaData;
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return fooIsReadOnly;
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {

	}

	@Override
	public String getCatalog() throws SQLException {
		return fooCatalog;
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {

	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return fooTransactionIsolation;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return fooSQLWarning;
	}

	@Override
	public void clearWarnings() throws SQLException {

	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		return fooStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		return fooCallableStatement;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return fooMapStringClass;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

	}

	@Override
	public void setHoldability(int holdability) throws SQLException {

	}

	@Override
	public int getHoldability() throws SQLException {
		return fooHoldability;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		return fooSavepoint;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		return fooSavepoint;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {

	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {

	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return fooStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return fooCallableStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return fooPreparedStatement;
	}

	@Override
	public Clob createClob() throws SQLException {
		return fooClob;
	}

	@Override
	public Blob createBlob() throws SQLException {
		return fooBlob;
	}

	@Override
	public NClob createNClob() throws SQLException {
		return fooNClob;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return fooSQLXML;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		return fooValid;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {

	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {

	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		return fooClientInfo;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return fooProperties;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		return fooArray;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		return fooStruct;
	}

	@Override
	public void setSchema(String schema) throws SQLException {

	}

	@Override
	public String getSchema() throws SQLException {
		return fooSchema;
	}

	@Override
	public void abort(Executor executor) throws SQLException {

	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		return fooNetworkTimeout;
	}

}
