package com.donate.orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBBuilder {

	private static Logger logger = LoggerFactory.getLogger(DBBuilder.class);
	private static SqlSessionFactory factory;
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("com/donate/orm/MybatisConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
