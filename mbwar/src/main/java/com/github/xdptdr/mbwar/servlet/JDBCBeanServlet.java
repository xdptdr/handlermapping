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

	private static final long serialVersionUID = 1L;

	@EJB
	private JDBCBeanI bean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try {

			Map<String, Map<String, String>> allDbProps = new HashMap<>();

			String[] dbNames = new String[] { "H2", "MySQL", "PostgreSQL", "SQLServer" };
			List<String> propNames = new ArrayList<>();

			for (String dbName : dbNames) {

				DatabaseMetaData md = null;
				try {
					md = getConnection(dbName);
				} catch (Exception ex) {

				}

				Map<String, String> props = new HashMap<>();

				boolean first = true;
				for (Method method : DatabaseMetaData.class.getMethods()) {
					if (method.getParameterTypes().length == 0) {
						if (method.getReturnType() == boolean.class) {
							if (md != null) {
								props.put(method.getName(), method.invoke(md).toString());
							} else {
								props.put(method.getName(), "Error");
							}
							if (first) {
								propNames.add(method.getName());
							}
						}
						// else if (method.getReturnType() == String.class) {
						// props.put(method.getName(),
						// method.invoke(md).toString());
						// }
					}
					first = false;
				}
				allDbProps.put(dbName, props);
			}

			req.setAttribute("allDbProps", allDbProps);
			req.setAttribute("dbNames", dbNames);
			req.setAttribute("propNames", propNames.toArray());

			req.getRequestDispatcher("/WEB-INF/jsp/jdbc.jsp").forward(req, resp);
		} catch (ServletException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}

	private DatabaseMetaData getConnection(String db) throws SQLException {
		switch (db) {
		case "H2":
			return bean.getH2Connection().getMetaData();
		case "MySQL":
			return bean.getMysqlConnection().getMetaData();
		case "PostgreSQL":
			return bean.getPostgresqlConnection().getMetaData();
		case "SQLServer":
			return bean.getSqlServerConnection().getMetaData();
		}
		return null;
	}
}
