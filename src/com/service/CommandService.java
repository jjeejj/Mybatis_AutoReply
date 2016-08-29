package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.bean.Command;
import com.bean.Content;
import com.dao.CommandDao;
import com.util.Constant;


public class CommandService {
	public List<Command> queryCommandList(String name,String description) throws ClassNotFoundException, SQLException{
		
		//mybatis方法查询
		CommandDao commandDao = new CommandDao();
		return commandDao.queryCommandList(name, description);
	}
	
	/**
	 * 通过指令查询内容
	 * command表
	 * @param command
	 * @return
	 */
	public String queryByCommand(String name){
		CommandDao commandDao = new CommandDao();
		List<Command> commandList = null;
		
		if(Constant.HELP.equals(name)){
			commandList = commandDao.queryCommandList(null, null);
			StringBuffer  sb = new StringBuffer();
			for (int i = 0; i < commandList.size(); i++) {
				Command command = commandList.get(i);
				if(i!=0){
					sb.append("<br/>");
				}		
				sb.append("回复["+command.getName()+"]"+"可以查看："+command.getDescription());
			}
			
			return sb.toString();
		}
		
		commandList = commandDao.queryCommandList(name, null);
		if(commandList!=null && commandList.size() >0){
			List<Content> contentList = commandList.get(0).getContents();
			if(contentList !=null && contentList.size()>0){
				int i  = new Random().nextInt(contentList.size());
				return contentList.get(i).getContent();
			}
		}
		return Constant.NO_MATCHING_CONTENT;
	}
}
