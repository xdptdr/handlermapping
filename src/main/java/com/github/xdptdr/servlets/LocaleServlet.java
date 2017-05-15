package com.github.xdptdr.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		StringBuffer buf = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DAY_OF_MONTH, 01);
		cal.set(Calendar.HOUR, 18);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		buf.append("<table><tbody>");
		for (Locale locale : Locale.getAvailableLocales()) {
			DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
			String formatted = format.format(cal.getTime());
			buf.append("<tr><td>" + getLocaleString(locale) + "</td><td>"+locale.getDisplayName()+"</td><td>" + formatted + "</tr>");
			buf.append("\n");
		}
		buf.append("</tbody></table>");
		resp.getWriter().println(buf.toString());
	}

	private String getLocaleString(Locale locale) {
		if (locale.getCountry() != null && locale.getCountry().trim().length() > 0) {
			return locale.getLanguage() + "_" + locale.getCountry();
		} else {
			return locale.getLanguage();
		}
	}
}
