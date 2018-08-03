package org.xy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	@Override//获取当前Servlet的初始化参数
	public void init() throws ServletException {
		System.out.println("init...");
		String value=super.getInitParameter("servletparam");
		System.out.println("servlet:"+value);
		value=super.getServletContext().getInitParameter("globalParam");
		System.out.println("global:"+value);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
	}

}
