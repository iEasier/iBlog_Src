package com.iBlog.testdao;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.iBlog.entity.UserInfo;

public class UserInfoDaoTest {
	private static HashMap<Object, Object> result_Option = new HashMap<Object, Object>();

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String authentication = "authentication";// 映射sql的标识字符串
		result_Option.put("username", "fangliang");
		result_Option.put("password", "123");
		Map<Object, Object> userInfo_Result = sqlSession.selectOne(
				authentication, result_Option);
		System.out.println(userInfo_Result);
	}

	// Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "mybatis/MyBatis_Conf.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsReader(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
