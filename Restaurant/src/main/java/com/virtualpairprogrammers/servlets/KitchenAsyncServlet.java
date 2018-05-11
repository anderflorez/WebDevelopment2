package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.Order;

@WebServlet(value="/kitchenAsyncServlet", asyncSupported = true)
public class KitchenAsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 7400439255119330937L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AsyncContext asyncContext = request.startAsync(request, response);
		KitchenAsyncTask task = new KitchenAsyncTask();
		task.setAsyncContext(asyncContext);
		asyncContext.start(task);
		
	}
}
