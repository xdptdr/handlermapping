package com.github.xdptdr.mbejb.api;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public interface JDBCBeanI {

	public DatabaseMetaData getDatabaseMetaData() throws SQLException;

}
