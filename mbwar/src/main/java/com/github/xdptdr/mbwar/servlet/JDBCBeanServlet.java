package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.mbejb.api.JDBCBeanI;

@WebServlet("/jdbcServlet")
public class JDBCBeanServlet extends HttpServlet {

	public static enum DBNAME {
		H2, PO, MY, SQ
	}

	private static final long serialVersionUID = 1L;

	@EJB
	private JDBCBeanI bean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try {

			List<ColumnDescription> rowNames = new ArrayList<>();
			List<String> columnNames = new ArrayList<>();
			List<String> otherMethods = new ArrayList<>();
			Map<String, Map<String, Cell>> table = new HashMap<String, Map<String, Cell>>();
			boolean methodsProcessed = false;

			Map<String, Map<String, Set<String>>> commaSeparatedListValuesPerDb = new HashMap<>();
			Map<String, Set<String>> allCommaSeparatedListSets = new HashMap<>();
			Map<String, List<String>> allCommaSeparatedLists = new HashMap<>();

			Set<String> commaSeparatedListGetters = new HashSet<>(Arrays.asList(new String[] { "getNumericFunctions",
					"getSQLKeywords", "getStringFunctions", "getSystemFunctions", "getTimeDateFunctions" }));

			Map<String, String> commaSeparatedListGettersTitles = new HashMap<>();
			commaSeparatedListGettersTitles.put("getNumericFunctions", "Numeric functions");
			commaSeparatedListGettersTitles.put("getSQLKeywords", "SQL Keywords");
			commaSeparatedListGettersTitles.put("getStringFunctions", "String Functions");
			commaSeparatedListGettersTitles.put("getSystemFunctions", "System Functions");
			commaSeparatedListGettersTitles.put("getTimeDateFunctions", "Time and Date Functions");

			for (DBNAME dbName : DBNAME.values()) {

				DatabaseMetaData md = null;
				try {
					md = getConnection(dbName);
				} catch (Exception ex) {

				}

				columnNames.add(dbName.toString());

				Map<String, Cell> columnValues = new HashMap<>();

				for (Method method : DatabaseMetaData.class.getMethods()) {

					boolean methodProcessed = false;
					String type = null;

					if (method.getParameterTypes().length == 0) {
						if (commaSeparatedListGetters.contains(method.getName())) {
							if (!methodsProcessed) {
								allCommaSeparatedListSets.put(method.getName(), new HashSet<>());
								commaSeparatedListValuesPerDb.put(method.getName(), new HashMap<>());
							}
							Set<String> commaSeparatedListValues = new HashSet<>();
							for (String numericFunction : ((String) method.invoke(md)).split(",")) {
								commaSeparatedListValues.add(numericFunction.trim().toUpperCase());
								allCommaSeparatedListSets.get(method.getName())
										.add(numericFunction.trim().toUpperCase());
							}

							commaSeparatedListValuesPerDb.get(method.getName()).put(dbName.toString(),
									commaSeparatedListValues);
						} else if (method.getReturnType() == boolean.class) {
							boolean value = (boolean) method.invoke(md);
							Cell cell = new Cell(value ? "T" : "F");
							type = "boolean";
							cell.setClassName(value ? "T" : "F");
							columnValues.put(method.getName(), cell);
							methodProcessed = true;
						} else if (method.getReturnType() == int.class) {
							columnValues.put(method.getName(), new Cell(Integer.toString((int) method.invoke(md))));
							type = "integer";
							methodProcessed = true;
						} else if (method.getReturnType() == String.class) {
							columnValues.put(method.getName(), new Cell((String) method.invoke(md)));
							type = "string";
							methodProcessed = true;
						}
					}

					if (!methodsProcessed) {
						if (!methodProcessed) {
							otherMethods.add(method.toString());
						} else {
							rowNames.add(new ColumnDescription(method.getName(), type));
						}
					}
				}
				methodsProcessed = true;

				table.put(dbName.toString(), columnValues);
			}

			for (String getter : commaSeparatedListGetters) {
				allCommaSeparatedLists.put(getter, new ArrayList<>());
				for (String nFn : allCommaSeparatedListSets.get(getter)) {
					allCommaSeparatedLists.get(getter).add(nFn);
				}
				Collections.sort(allCommaSeparatedLists.get(getter));
			}

			req.setAttribute("rowNames", rowNames);
			req.setAttribute("columnNames", columnNames);
			req.setAttribute("table", table);
			req.setAttribute("allCommaSeparatedLists", allCommaSeparatedLists);
			req.setAttribute("commaSeparatedListValuesPerDb", commaSeparatedListValuesPerDb);
			req.setAttribute("otherMethods", otherMethods);
			req.setAttribute("commaSeparatedListGettersTitles", commaSeparatedListGettersTitles);
			req.getRequestDispatcher("/WEB-INF/jsp/jdbc.jsp").forward(req, resp);
		} catch (ServletException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}

	private DatabaseMetaData getConnection(DBNAME db) throws SQLException {
		switch (db) {
		case H2:
			return bean.getH2Connection().getMetaData();
		case MY:
			return bean.getMysqlConnection().getMetaData();
		case PO:
			return bean.getPostgresqlConnection().getMetaData();
		case SQ:
			return bean.getSqlServerConnection().getMetaData();
		}
		return null;
	}
}
