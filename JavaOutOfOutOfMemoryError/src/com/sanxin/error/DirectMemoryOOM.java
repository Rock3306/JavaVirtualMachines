package com.sanxin.error;

import java.lang.reflect.Field;

/**
 * 使用 unsafe 分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author rocki
 *
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws Exception {
		// Unsafe jdk 1.5才有
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
        
        // 运行结果 OutOfMeoryError
    }	

}
