package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.Message;
import com.dao.MessageDao;
import com.dao.MessageMybatisDao;
import com.util.Constant;

public class MessageService {
	
	/**
	 * 查询
	 * @param command
	 * @param description
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Message> queryMessageList(String command,String description) throws ClassNotFoundException, SQLException{
//		MessageDao messageDao = new MessageDao();
//		return messageDao.queryMessageList(command, description);
		
		//mybatis方法查询
		MessageMybatisDao messageMybatisDao = new MessageMybatisDao();
		return messageMybatisDao.queryMessageList(command, description);
	}
	/**
	 * 通过指令查询内容
	 * message表
	 * @param command
	 * @return
	 */
	public String queryByCommand(String command){
		MessageMybatisDao messageMybatisDao = new MessageMybatisDao();
		List<Message> messageList = null;
		
		if(Constant.HELP.equals(command)){
			messageList = messageMybatisDao.queryMessageList(null, null);
			StringBuffer  sb = new StringBuffer();
			for (int i = 0; i < messageList.size(); i++) {
				Message message = messageList.get(i);
				if(i!=0){
					sb.append("<br/>");
				}		
				sb.append("回复["+message.getCommand()+"]"+"可以查看："+message.getDescription());
			}
			
			return sb.toString();
		}
		
		messageList = messageMybatisDao.queryMessageList(command, null);
		if(messageList!=null && messageList.size() >0){
			return messageList.get(0).getContent();
		}
		return Constant.NO_MATCHING_CONTENT;
	}
	
	/**
	 * 删除某一条
	 * @param id
	 */
	public void deleteOne(String id) {
		if(id!=null && !"".equals(id.trim())){
			MessageMybatisDao messageMybatisDao = new MessageMybatisDao();
			messageMybatisDao.deleteOne(Integer.valueOf(id));
		}
	}
	/**
	 * 批量删除
	 * @param list
	 */
	public void deleteBatch(String[] ids) {
		
		MessageMybatisDao messageMybatisDao = new MessageMybatisDao();
		//数组抓化为List
//		List<String> ids =  Arrays.asList(ids);
		List<Integer> idsList = new ArrayList<Integer>();
		for (String string : ids) {
			idsList.add(Integer.valueOf(string));
		}
		messageMybatisDao.deleteBatch(idsList);
	}
	
	/**
	 * 插入一条记录
	 * @param message
	 */
	public void insert(Message message){
		MessageMybatisDao messageMybatisDao = new MessageMybatisDao();
		messageMybatisDao.insert(message);
	}
}
