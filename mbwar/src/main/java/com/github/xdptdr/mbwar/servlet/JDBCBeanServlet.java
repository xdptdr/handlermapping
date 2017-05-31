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

			List<String> booleanPropNames = new ArrayList<>();
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
						} else {
							if (first) {
								otherMethods.add(method.toString());
							}
						}
					}
				}
				allBooleanDbProps.put(dbName.toString(), booleanProps);
				first = false;
			}

			req.setAttribute("allBooleanDbProps", allBooleanDbProps);
			req.setAttribute("dbNames", dbNames);
			req.setAttribute("booleanPropNames", booleanPropNames);
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
