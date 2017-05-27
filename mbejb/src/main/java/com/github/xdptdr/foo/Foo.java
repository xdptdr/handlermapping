package com.github.xdptdr.foo;

import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Foo {
	public void foo() throws SQLException {

		Driver driver = new FooDriver();
		DatabaseMetaData md = driver.connect(null, null).getMetaData();

		{
			boolean b = false;

			b = md.isReadOnly();
			b = md.allProceduresAreCallable();
			b = md.allTablesAreSelectable();
			b = md.autoCommitFailureClosesAllResultSets();
			b = md.dataDefinitionCausesTransactionCommit();
			b = md.dataDefinitionIgnoredInTransactions();

			b = md.doesMaxRowSizeIncludeBlobs();
			b = md.generatedKeyAlwaysReturned();

			b = md.isCatalogAtStart();
			b = md.locatorsUpdateCopy();
			b = md.nullPlusNonNullIsNull();
			b = md.nullsAreSortedAtEnd();
			b = md.nullsAreSortedAtStart();
			b = md.nullsAreSortedHigh();
			b = md.nullsAreSortedLow();

			b = md.storesLowerCaseIdentifiers();
			b = md.storesLowerCaseQuotedIdentifiers();
			b = md.storesMixedCaseIdentifiers();
			b = md.storesMixedCaseQuotedIdentifiers();
			b = md.storesUpperCaseIdentifiers();
			b = md.storesUpperCaseQuotedIdentifiers();
			b = md.supportsANSI92EntryLevelSQL();
			b = md.supportsANSI92FullSQL();
			b = md.supportsANSI92IntermediateSQL();
			b = md.supportsAlterTableWithAddColumn();
			b = md.supportsAlterTableWithDropColumn();
			b = md.supportsBatchUpdates();
			b = md.supportsCatalogsInDataManipulation();
			b = md.supportsCatalogsInIndexDefinitions();
			b = md.supportsCatalogsInPrivilegeDefinitions();
			b = md.supportsCatalogsInProcedureCalls();
			b = md.supportsCatalogsInTableDefinitions();
			b = md.supportsColumnAliasing();
			b = md.supportsConvert();
			b = md.supportsConvert();
			b = md.supportsCoreSQLGrammar();
			b = md.supportsCorrelatedSubqueries();
			b = md.supportsDataDefinitionAndDataManipulationTransactions();
			b = md.supportsDataManipulationTransactionsOnly();
			b = md.supportsDifferentTableCorrelationNames();
			b = md.supportsExpressionsInOrderBy();
			b = md.supportsExtendedSQLGrammar();
			b = md.supportsFullOuterJoins();
			b = md.supportsGetGeneratedKeys();
			b = md.supportsGroupBy();
			b = md.supportsGroupByBeyondSelect();
			b = md.supportsGroupByUnrelated();
			b = md.supportsIntegrityEnhancementFacility();
			b = md.supportsLikeEscapeClause();
			b = md.supportsLimitedOuterJoins();
			b = md.supportsMinimumSQLGrammar();
			b = md.supportsMixedCaseIdentifiers();
			b = md.supportsMixedCaseQuotedIdentifiers();
			b = md.supportsMultipleOpenResults();
			b = md.supportsMultipleResultSets();
			b = md.supportsMultipleTransactions();
			b = md.supportsNamedParameters();
			b = md.supportsNonNullableColumns();
			b = md.supportsOpenCursorsAcrossCommit();
			b = md.supportsOpenCursorsAcrossRollback();
			b = md.supportsOpenStatementsAcrossCommit();
			b = md.supportsOpenStatementsAcrossRollback();
			b = md.supportsOrderByUnrelated();
			b = md.supportsOuterJoins();
			b = md.supportsPositionedDelete();
			b = md.supportsPositionedUpdate();
			b = md.supportsRefCursors();

			b = md.supportsSavepoints();
			b = md.supportsSchemasInDataManipulation();
			b = md.supportsSchemasInIndexDefinitions();
			b = md.supportsSchemasInPrivilegeDefinitions();
			b = md.supportsSchemasInProcedureCalls();
			b = md.supportsSchemasInTableDefinitions();
			b = md.supportsSelectForUpdate();
			b = md.supportsStatementPooling();
			b = md.supportsStoredFunctionsUsingCallSyntax();
			b = md.supportsStoredProcedures();
			b = md.supportsSubqueriesInComparisons();
			b = md.supportsSubqueriesInExists();
			b = md.supportsSubqueriesInIns();
			b = md.supportsSubqueriesInQuantifieds();
			b = md.supportsTableCorrelationNames();

			b = md.supportsTransactions();
			b = md.supportsUnion();
			b = md.supportsUnionAll();

			b = md.usesLocalFilePerTable();
			b = md.usesLocalFiles();

		}

		{
			ResultSet b = null;

			b = md.getSchemas();
			b = md.getSchemas();
			b = md.getTableTypes();
			b = md.getTypeInfo();
			b = md.getCatalogs();
			b = md.getClientInfoProperties();
		}
		{
			String b = null;

			b = md.getURL();

			b = md.getCatalogSeparator();
			b = md.getCatalogTerm();

			b = md.getDatabaseProductName();
			b = md.getDatabaseProductVersion();

			b = md.getDriverName();
			b = md.getDriverVersion();

			b = md.getExtraNameCharacters();

			b = md.getIdentifierQuoteString();

			b = md.getNumericFunctions();

			b = md.getProcedureTerm();

			b = md.getSQLKeywords();

			b = md.getSchemaTerm();

			b = md.getSearchStringEscape();
			b = md.getStringFunctions();

			b = md.getSystemFunctions();

			b = md.getTimeDateFunctions();

			b = md.getUserName();

		}

		{
			int b = 0;

			b = md.getDatabaseMajorVersion();
			b = md.getDatabaseMinorVersion();
			b = md.getDefaultTransactionIsolation();
			b = md.getDriverMajorVersion();
			b = md.getDriverMinorVersion();
			b = md.getJDBCMajorVersion();
			b = md.getJDBCMinorVersion();
			b = md.getMaxBinaryLiteralLength();
			b = md.getMaxCatalogNameLength();
			b = md.getMaxCharLiteralLength();
			b = md.getMaxColumnNameLength();
			b = md.getMaxColumnsInGroupBy();
			b = md.getMaxColumnsInIndex();
			b = md.getMaxColumnsInOrderBy();
			b = md.getMaxColumnsInSelect();
			b = md.getMaxColumnsInTable();
			b = md.getMaxConnections();
			b = md.getMaxCursorNameLength();
			b = md.getMaxIndexLength();

			b = md.getMaxProcedureNameLength();
			b = md.getMaxRowSize();
			b = md.getMaxSchemaNameLength();
			b = md.getMaxStatementLength();
			b = md.getMaxStatements();
			b = md.getMaxTableNameLength();
			b = md.getMaxTablesInSelect();
			b = md.getMaxUserNameLength();
			b = md.getResultSetHoldability();

			b = md.getSQLStateType();
		}

		{
			Object b = null;
			b = md.getConnection();
			b = md.getMaxLogicalLobSize();
			b = md.getRowIdLifetime();
		}
	}

	{
		// those require arguments
		// b = md.getAttributes();
		// b = md.deletesAreDetected();
		// b = md.getBestRowIdentifier();
		// b = md.getColumnPrivileges();
		// b = md.getColumns();
		// b = md.getCrossReference();
		// b = md.getExportedKeys();
		// b = md.getFunctionColumns();
		// b = md.getFunctions();
		// b = md.getImportedKeys();
		// b = md.getIndexInfo();
		// b = md.getPrimaryKeys();
		// b = md.getProcedureColumns();
		// b = md.getProcedures();
		// b = md.getPseudoColumns();
		// b = md.getSuperTables();
		// b = md.getSuperTypes();
		// b = md.getTablePrivileges();
		// b = md.getTables();
		// b = md.getUDTs();
		// b = md.getVersionColumns();
		// b = md.insertsAreDetected();
		// b = md.othersDeletesAreVisible();
		// b = md.othersInsertsAreVisible();
		// b = md.othersUpdatesAreVisible();
		// b = md.ownDeletesAreVisible();
		// b = md.ownInsertsAreVisible();
		// b = md.ownUpdatesAreVisible();
		//
		// b = md.supportsResultSetConcurrency();
		// b = md.supportsResultSetHoldability();
		// b = md.supportsResultSetType();
		//
		// b = md.supportsTransactionIsolationLevel();
		//
		// b = md.updatesAreDetected();
		//
		// b = md.unwrap();
		// b = md.isWrapperFor();
	}

	public static void main(String[] args) {

		for (Method method : DatabaseMetaData.class.getMethods()) {
			System.out.println("b = md." + method.getName() + "();");
		}
	}
}
