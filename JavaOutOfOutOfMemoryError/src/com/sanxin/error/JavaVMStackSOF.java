package com.sanxin.error;

/**
 * 虚拟机栈和本地方法栈溢出
 * VM Args: -Xss128k
 * 
 * @author rocki
 *
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeck(){
		stackLength ++;
		stackLeck();
	}

	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeck();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength + "\n");
			throw e;
		}
	}

}
