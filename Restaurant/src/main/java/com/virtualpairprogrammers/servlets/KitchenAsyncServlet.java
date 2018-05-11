package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
