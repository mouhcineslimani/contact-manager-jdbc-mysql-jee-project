package org.mql.users.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mql.users.business.ContactFactory;
import org.mql.users.business.ContactService;
import org.mql.users.web.actions.UserAction;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String preffix = "/views/";
	private String suffix = ".jsp";
	private UserAction action;

	@Override
	public void init() throws ServletException {
		ContactService service = ContactFactory.getService();
		action = new UserAction(service);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("ajax")) {

		} else {
			if (url.endsWith("select-all-users")) {

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
