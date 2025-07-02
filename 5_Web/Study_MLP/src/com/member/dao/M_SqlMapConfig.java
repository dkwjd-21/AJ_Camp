package com.member.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class M_SqlMapConfig {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSessionFactory() {
		
		try {
			Reader reader = Resources.getResourceAsReader("db/member_config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
