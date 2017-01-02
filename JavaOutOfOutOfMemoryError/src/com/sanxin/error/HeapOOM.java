package com.sanxin.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * 
 * （堆的最小值-Xms参数与最大值-Xmx最大值参数）
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author rocki
 *
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while (true) {
			list.add(new OOMObject());
		}
	}

}