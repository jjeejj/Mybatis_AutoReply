package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.bean.Message;
import com.db.DBAccessUtils;

/**
 * 
 * @author jiang
 *
 */
public class MessageMybatisDao {
	
	public List<Message> queryMessageList(String command,String description){
		
		SqlSession sqlSession = null;
		List<Message> messageList= new ArrayList<Message>();
		try {
			 sqlSession = DBAccessUtils.getSqlSession();
			 Message message = new Message();
			 message.setCommand(command);
			 message.setDescription(description);
			 //通过sqlSession 执行sql语句
			 IMessageDao iMessageDao  = sqlSession.getMapper(IMessageDao.class);
			 messageList = iMessageDao.queryMessageList(message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if(sqlSession!=null){
				sqlSession.close();
			}		
		}
		return messageList;
	}
	/**
	 * 根据id进行删除
	 * @param id 主键
	 */
	public void deleteOne(int id){
		SqlSession sqlSession = null;

		try {
			 sqlSession = DBAccessUtils.getSqlSession();
			 //通过sqlSession 执行sql语句
			 sqlSession.delete("Message.deleteOne",id);
			 //mybatis事务不自动提交需手动提交
			 sqlSession.commit();
//			 Logger
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if(sqlSession!=null){
				sqlSession.close();
			}		
		}
	}
	
	/**
	 * 删除一组数据
	 * @param list
	 */
	public void deleteBatch(List<Integer> ids){
		SqlSession sqlSession = null;

		try {
			 sqlSession = DBAccessUtils.getSqlSession();
			 //通过sqlSession 执行sql语句
			 sqlSession.delete("Message.deleteBatch",ids);
			 //mybatis事务不自动提交需手动提交
			 sqlSession.commit();
//			 Logger
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if(sqlSession!=null){
				sqlSession.close();
			}		
		}
	}
	
	/**
	 * 插入一条记录
	 * @param message
	 */
	public void insert(Message message){
		SqlSession sqlSession = null;
		try {
			 sqlSession = DBAccessUtils.getSqlSession();
			 //通过sqlSession 执行sql语句
			 sqlSession.insert("Message.deleteBatch",message);
			 //mybatis事务不自动提交需手动提交
			 sqlSession.commit();
//			 Logger
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if(sqlSession!=null){
				sqlSession.close();
			}		
		}
	}

	public static void main(String[] args) {
		MessageMybatisDao messageMybatisDao =new MessageMybatisDao();
		List<Message> messageList = messageMybatisDao.queryMessageList("", "");
		for (Message message : messageList) {
			System.out.println(message.toString());
		}
	}
}
