package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

			Map<String, Map<String, String>> allBooleanDbProps = new HashMap<>();
			Map<String, Map<String, String>> allIntDbProps = new HashMap<>();
			Map<String, Map<String, String>> allStringDbProps = new HashMap<>();

			List<String> booleanPropNames = new ArrayList<>();
			List<String> intPropNames = new ArrayList<>();
			List<String> stringPropNames = new ArrayList<>();
			List<String> otherMethods = new ArrayList<>();
			List<String> dbNames = new ArrayList<>();
			boolean first = true;
			for (DBNAME dbName : DBNAME.values()) {
				dbNames.add(dbName.toString());
				DatabaseMetaData md = null;
				try {
					md = getConnection(dbName);
				} catch (Exception ex) {

				}

				Map<String, String> booleanProps = new HashMap<>();
				Map<String, String> intProps = new HashMap<>();
				Map<String, String> stringProps = new HashMap<>();

				for (Method method : DatabaseMetaData.class.getMethods()) {
					if (method.getParameterTypes().length == 0) {
						if (method.getReturnType() == boolean.class) {
							if (md != null) {
								booleanProps.put(method.getName(), ((boolean) method.invoke(md)) ? "T" : "F");
							} else {
								booleanProps.put(method.getName(), "Error");
							}
							if (first) {
								booleanPropNames.add(method.getName());
							}
						} else if (method.getReturnType() == int.class) {
							if (md != null) {
								intProps.put(method.getName(), Integer.toString((int) method.invoke(md)));
							} else {
								intProps.put(method.getName(), "Error");
							}
							if (first) {
								intPropNames.add(method.getName());
							}
						} else if (method.getReturnType() == String.class) {
							if (md != null) {
								stringProps.put(method.getName(), (String) method.invoke(md));
							} else {
								stringProps.put(method.getName(), "Error");
							}
							if (first) {
								stringPropNames.add(method.getName());
							}
						} else {
							if (first) {
								otherMethods.add(method.toString());
							}
						}
					}
				}
				allBooleanDbProps.put(dbName.toString(), booleanProps);
				allIntDbProps.put(dbName.toString(), intProps);
				allStringDbProps.put(dbName.toString(), stringProps);
				first = false;
			}

			req.setAttribute("allBooleanDbProps", allBooleanDbProps);
			req.setAttribute("allIntDbProps", allIntDbProps);
			req.setAttribute("allStringDbProps", allStringDbProps);
			req.setAttribute("dbNames", dbNames);
			req.setAttribute("booleanPropNames", booleanPropNames);
			req.setAttribute("intPropNames", intPropNames);
			req.setAttribute("stringPropNames", stringPropNames);
			req.setAttribute("otherMethods", otherMethods);
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
