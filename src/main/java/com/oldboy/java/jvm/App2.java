package com.oldboy.java.jvm;

import java.lang.reflect.Method;

/**
 *
 */
public class App2 {
	public static void main(String[] args) throws Exception {
		ClassLoader loader = new MyClassLoader();
		Class clz = loader.loadClass("ByeServiceImpl") ;
		IByeService bs = (IByeService) clz.newInstance();
		bs.sayBye("tomtomt");
	}
}
