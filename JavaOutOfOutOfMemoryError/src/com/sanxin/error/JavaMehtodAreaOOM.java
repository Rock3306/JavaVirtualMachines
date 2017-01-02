package com.sanxin.error;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 借助 CGLib 使方法区出现内存溢出异常
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author rocki
 *
 */
public class JavaMehtodAreaOOM {

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object ovj, Method mehtod, Object[] args, MethodProxy proxy) throws Throwable {
					
					return proxy.invokeSuper(ovj, args);
				}
			});
			enhancer.create();
		}
	}
	
	static class OOMObject{}

}
