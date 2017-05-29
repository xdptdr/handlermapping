package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.mbejb.api.JDBCBeanI;

@WebServlet("/jdbcServlet")
public class JDBCBeanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	JDBCBeanI bean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try {
			DatabaseMetaData md = bean.getDatabaseMetaData();
			req.setAttribute("md", md);
			req.getRequestDispatcher("/WEB-INF/jsp/jdbc.jsp").forward(req, resp);
		} catch (ServletException | SQLException e) {
			throw new RuntimeException(e);
		}

		// PrintWriter pw = resp.getWriter();
		//
		// String[] booleanMethods = { "isReadOnly", "allProceduresAreCallable",
		// "allTablesAreSelectable",
		// "autoCommitFailureClosesAllResultSets",
		// "dataDefinitionCausesTransactionCommit",
		// "dataDefinitionIgnoredInTransactions", "doesMaxRowSizeIncludeBlobs",
		// "generatedKeyAlwaysReturned",
		// "isCatalogAtStart", "locatorsUpdateCopy", "nullPlusNonNullIsNull",
		// "nullsAreSortedAtEnd",
		// "nullsAreSortedAtStart", "nullsAreSortedHigh", "nullsAreSortedLow",
		// "storesLowerCaseIdentifiers",
		// "storesLowerCaseQuotedIdentifiers", "storesMixedCaseIdentifiers",
		// "storesMixedCaseQuotedIdentifiers",
		// "storesUpperCaseIdentifiers", "storesUpperCaseQuotedIdentifiers",
		// "supportsANSI92EntryLevelSQL",
		// "supportsANSI92FullSQL", "supportsANSI92IntermediateSQL",
		// "supportsAlterTableWithAddColumn",
		// "supportsAlterTableWithDropColumn", "supportsBatchUpdates",
		// "supportsCatalogsInDataManipulation",
		// "supportsCatalogsInIndexDefinitions",
		// "supportsCatalogsInPrivilegeDefinitions",
		// "supportsCatalogsInProcedureCalls",
		// "supportsCatalogsInTableDefinitions", "supportsColumnAliasing",
		// "supportsConvert", "supportsCoreSQLGrammar",
		// "supportsCorrelatedSubqueries",
		// "supportsDataDefinitionAndDataManipulationTransactions",
		// "supportsDataManipulationTransactionsOnly",
		// "supportsDifferentTableCorrelationNames",
		// "supportsExpressionsInOrderBy", "supportsExtendedSQLGrammar",
		// "supportsFullOuterJoins", "supportsGetGeneratedKeys",
		// "supportsGroupBy", "supportsGroupByBeyondSelect",
		// "supportsGroupByUnrelated", "supportsIntegrityEnhancementFacility",
		// "supportsLikeEscapeClause",
		// "supportsLimitedOuterJoins", "supportsMinimumSQLGrammar",
		// "supportsMixedCaseIdentifiers",
		// "supportsMixedCaseQuotedIdentifiers", "supportsMultipleOpenResults",
		// "supportsMultipleResultSets",
		// "supportsMultipleTransactions", "supportsNamedParameters",
		// "supportsNonNullableColumns",
		// "supportsOpenCursorsAcrossCommit",
		// "supportsOpenCursorsAcrossRollback",
		// "supportsOpenStatementsAcrossCommit",
		// "supportsOpenStatementsAcrossRollback",
		// "supportsOrderByUnrelated", "supportsOuterJoins",
		// "supportsPositionedDelete",
		// "supportsPositionedUpdate", "supportsRefCursors",
		// "supportsSavepoints",
		// "supportsSchemasInDataManipulation",
		// "supportsSchemasInIndexDefinitions",
		// "supportsSchemasInPrivilegeDefinitions",
		// "supportsSchemasInProcedureCalls",
		// "supportsSchemasInTableDefinitions", "supportsSelectForUpdate",
		// "supportsStatementPooling",
		// "supportsStoredFunctionsUsingCallSyntax", "supportsStoredProcedures",
		// "supportsSubqueriesInComparisons",
		// "supportsSubqueriesInExists", "supportsSubqueriesInIns",
		// "supportsSubqueriesInQuantifieds",
		// "supportsTableCorrelationNames", "supportsTransactions",
		// "supportsUnion", "supportsUnionAll",
		// "usesLocalFilePerTable", "usesLocalFiles" };
		//
		// try {
		// DatabaseMetaData md = bean.getDatabaseMetaData();
		// for (String booleanMethod : booleanMethods) {
		// Object v =
		// DatabaseMetaData.class.getMethod(booleanMethod).invoke(md);
		// pw.println(booleanMethod + " : " + v);
		// }
		//
		// } catch (SQLException | IllegalAccessException |
		// IllegalArgumentException | InvocationTargetException
		// | NoSuchMethodException | SecurityException e) {
		// throw new RuntimeException(e);
		// }

	}
}
