package org.mql.users.web.actions;

import org.mql.users.business.ContactService;

public class UserAction {
	private ContactService service;
	private Object model;

	public UserAction(ContactService service) {
		this.service = service;
	}

	public String getAllUsers() {
		model = service.users();
		return "print-all-users";
	}

	public String getUsersBy(String keyword) {
		model = service.usersByKeyword(keyword);
		return "print-all-users";
	}

	public Object getModel() {
		return model;
	}
}
