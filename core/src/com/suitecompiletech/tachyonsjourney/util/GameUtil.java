package com.suitecompiletech.tachyonsjourney.util;

import java.util.HashSet;

public class GameUtil {
	public static HashSet<String> doOnceSet = new HashSet<String>();
	
	public static boolean startEventOnce(String eventName) {
		if (doOnceSet.contains(eventName)) {
			return false;
		} else {
			doOnceSet.add(eventName);
			return true;
		}
	}
}
