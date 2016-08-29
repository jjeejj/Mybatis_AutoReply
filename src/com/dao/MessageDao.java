package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Message;

/**
 * 
 * @author jiang
 *
 */
public class MessageDao {
	
	public List<Message> queryMessageList(String command,String description) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis", "root", "root");
		
		StringBuffer sql = new StringBuffer("select id ,command,description,content from message where 1=1");
		
		List<String> paramList = new ArrayList<String>();
		if(command != null && !"".equals(command.trim())){
			sql.append(" and command = ?");
			paramList.add(command);
			
		}
		if(description != null && !"".equals(description.trim())){
			sql.append(" and description like '%' ? '%' ");
			paramList.add(description);
			
		}
		
		PreparedStatement  ps = connection.prepareStatement(sql.toString());
		if(paramList!=null && paramList.size() >0){
			for (int i = 0; i < paramList.size(); i++) {
				ps.setString(i+1, paramList.get(i));
			}
		}
		
		ResultSet rs = ps.executeQuery();
		List<Message> messageList = new ArrayList<Message>();
		while(rs.next()){
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setCommand(rs.getString("command"));
			message.setContent(rs.getString("content"));
			message.setDescription(rs.getString("description"));
			messageList.add(message);	
		}
		
		return messageList;
	}
}
