package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Message;
import com.service.MessageService;

/**
 * 插入一条记录Servlet
 * @author jiang
 *
 */
@SuppressWarnings("serial")
public class InsertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String command = req.getParameter("command");
		String content = req.getParameter("content");
		String description = req.getParameter("description");
		
		Message message = new Message();
		message.setCommand(command);
		message.setContent(content);
		message.setDescription(description);
		
		MessageService messageService  = new MessageService();
		messageService.insert(message);
		
		req.getRequestDispatcher("/list.action").forward(req, resp);
	}
	
}
