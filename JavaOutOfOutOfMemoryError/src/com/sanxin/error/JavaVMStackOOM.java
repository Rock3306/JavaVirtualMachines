package com.sanxin.error;

/**
 * 创建线程导致内存溢出线程
 *
 * VM Args: -Xss2M
 * 
 * 注意：特别提示一下，如果要尝试运行上面这段代码，记得要先保存当前的工作。由于在Windows平台的虚拟机中，
 * Java的线程时映射到操作系统的内核线程上的，因此上述代码执行时有较大风险，可能会导致操作系统假死。
 * 
 * @author rocki
 *
 */
public class JavaVMStackOOM {
	
	private void dontStop(){
		while(true);
	}
	
	public void stackLeakByThread(){
		while (true) {
			new Thread(
					 new Runnable() {
						public void run() {
							dontStop();
						}
					}
			).start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
