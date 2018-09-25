package com.oldboy.spring.aop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 */
public class MyMethodInterceptor implements MethodInterceptor {
	public long start;

	public MyMethodInterceptor() {
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		start = System.nanoTime();

		System.out.println("begin");
		//调用目标对象的方法
		Object obj = invocation.proceed();
		System.out.println("end");
		System.out.println(System.nanoTime() - start);
		return obj;
	}
}
