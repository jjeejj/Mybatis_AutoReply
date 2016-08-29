package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CommandService;
import com.service.MessageService;

/**
 * 自动回复
 * @author jiang
 *
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		String command = req.getParameter("content");
//		MessageService messageService  = new MessageService();
//		String content = messageService.queryByCommand(command);
		CommandService commandService = new CommandService();

		String content = commandService.queryByCommand(command);
		PrintWriter out = resp.getWriter();
		
		out.write(content);
		
		out.flush();
		out.close();
		
	}
}
