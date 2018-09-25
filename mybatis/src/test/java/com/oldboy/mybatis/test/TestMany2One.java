package com.oldboy.mybatis.test;

import com.oldboy.mybatis.domain.Order;
import com.oldboy.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试多对一关系
 */
public class TestMany2One {
	@Test
	public void testInsert() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession sess = sf.openSession();
		User u = new User();
		u.setId(2);

		Order o = new Order();
		o.setOrderNo("no001");
		o.setPrice(2000);
		o.setUser(u);
		sess.insert("orders.insert" , o) ;
		sess.commit();
		sess.close();
	}
}
