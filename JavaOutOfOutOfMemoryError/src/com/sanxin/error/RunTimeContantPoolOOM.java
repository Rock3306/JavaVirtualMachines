package com.sanxin.error;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 运行时常量池导致的内存溢出异常
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author rocki
 *
 */
public class RunTimeContantPoolOOM {

	public static void main(String[] args) {
		
		// jdk 1.6 会java.lang.OutOfMemoryError: PermGen space
		// jdk 1.7 while 循环将一直循环下去
		
		/*//使用 List 保持着常量池引用,避免 Full GC 回收常量池行为
		List<String> list = new ArrayList<String>();
		//10MB的 PermSize 在 Interger 范围内足够产生 OOM 了
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}*/
		
		
		/*String.intern()方法是一个native方法，
		它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，
		则返回代表池中这个字符串的string对象；
		否则，将此String对象包含的字符串添加到常量池中，并返回此String对象的引用。*/
		
		
		String str1 = new StringBuilder("计算器").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
		/*jdk 1.6中的结果为两个false，
		 intern()方法会把首次遇到的字符串实例复制到永久代中,返回的也是永久代中的这个字符串实例的引用，而
		 由 StringBuilder 创建的字符串实例在堆上,所以必然不是同一个引用
		 */
		
		/*
		 jdk 1.7(以及部分其他虚拟机，例如JRockit)的 intern() 实现不会再复制实例，只是再字符串中记录
		 首次出现的实例引用，因此 intern() 返回的引用和由 StringBuilder 创建的那个字符串实例是同一个
		 结果为 true 和 false
		 */
	}

}
