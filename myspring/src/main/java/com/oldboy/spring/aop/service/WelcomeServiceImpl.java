package com.oldboy.spring.aop.service;

/**
 * Created by Administrator on 2018/9/17.
 */
public class WelcomeServiceImpl implements WelcomeService {
	public void sayHello(String name) {
		System.out.println( "hello : " + name);
	}
}
