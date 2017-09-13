package com.iBlog.common;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class _SqlSessionFactory {
	
	public static  SqlSessionFactory _getSessionFactory(){
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
