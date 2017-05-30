package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
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
	JDBCBeanI bean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try {
			DatabaseMetaData md = bean.getMysqlConnection().getMetaData();

			Map<String, String> props = new HashMap<>();

			for (Method method : DatabaseMetaData.class.getMethods()) {
				if (method.getParameterTypes().length == 0) {
					if (method.getReturnType() == boolean.class) {
						props.put(method.getName(), method.invoke(md).toString());
					} else if (method.getReturnType() == String.class) {
						props.put(method.getName(), method.invoke(md).toString());
					}
				}
			}

			req.setAttribute("props", props);
			req.getRequestDispatcher("/WEB-INF/jsp/jdbc.jsp").forward(req, resp);
		} catch (ServletException | SQLException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}
}
