package org.support.project.web.test.stub;

import javax.servlet.http.Cookie;

public class StubCookie extends Cookie {
	private String name;
	private String value;
	
	public StubCookie() {
		this("", "");
	}
	
	
	public StubCookie(String name, String value) {
		super(name, value);
		this.name = name;
		this.value = value;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
