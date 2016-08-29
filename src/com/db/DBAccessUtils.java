package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccessUtils {
	/**
	 * 获取SqlSession对象
	 * @return
	 * @throws IOException 
	 */
	public static SqlSession getSqlSession() throws IOException {
		
		//通过配置文件回去数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/config/Configuration.xml");
		
		//通过配置信息构建SqlSessionFactory
		
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		
		//通过SqlSessionFactory打开一个数据库会话  SqlSession
		
		SqlSession sqlSession =	sqlSessionFactory.openSession();
		
		
		return sqlSession;
	}
}
