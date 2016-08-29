package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
import com.db.DBAccessUtils;

/**
 * 指定 dao
 * @author jiang
 *
 */

public class CommandDao {
	/**
	 * 指定列表
	 * @param name
	 * @param description
	 * @return
	 */
public List<Command> queryCommandList(String name,String description){
		
		SqlSession sqlSession = null;
		List<Command> commandList= new ArrayList<Command>();
		try {
			 sqlSession = DBAccessUtils.getSqlSession();
			 Command command = new Command();
			 command.setName(name);
			 command.setDescription(description);
			 //通过sqlSession 执行sql语句
			 ICommandDao iCommandDao = sqlSession.getMapper(ICommandDao.class);
			 
			 commandList = iCommandDao.queryCommandList(command);
			 
//			 commandList = sqlSession.selectList("com.dao.ICommandDao.queryCommandList",command);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if(sqlSession!=null){
				sqlSession.close();
			}		
		}
		return commandList;
	}
}
