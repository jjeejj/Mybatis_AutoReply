package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MessageService;

/**
 * 单条删除Servlet
 * @author jiang
 *
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数
		String id = req.getParameter("id"); 
		System.out.println("开始执行");
		
		MessageService messageService  = new MessageService();
		messageService.deleteOne(id);			
		
		//TODO RequestDispatcher与 forward 的知识？？？？？？
		req.getRequestDispatcher("/list.action").forward(req, resp);
	} 
}
