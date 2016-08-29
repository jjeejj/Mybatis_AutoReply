package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Command;
import com.bean.Message;
import com.service.CommandService;
import com.service.MessageService;

/**
 * 列表页面初始化
 * @author jiang
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		//查询参数
		String command = req.getParameter("command"); //命令
		String description = req.getParameter("description"); // 描述
		
//		MessageService messageService  = new MessageService();
		CommandService commandService  =new CommandService();
//		List<Message> messageList = null;
		List<Command> commandList = null;
		try {
//			messageList = messageService.queryMessageList(command, description);
			commandList = commandService.queryCommandList(command, description);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("command", command);
		req.setAttribute("description", description);
//		req.setAttribute("messageList", messageList);	
		req.setAttribute("messageList", commandList);
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
