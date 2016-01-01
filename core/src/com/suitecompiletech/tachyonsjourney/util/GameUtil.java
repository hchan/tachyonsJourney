package com.suitecompiletech.tachyonsjourney.util;

import java.util.HashSet;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;

public class GameUtil {
	public static HashSet<String> doOnceSet = new HashSet<String>();
	public static Random random = new Random();
	public static boolean startEventOnce(String eventName) {
		if (doOnceSet.contains(eventName)) {
			return false;
		} else {
			doOnceSet.add(eventName);
			return true;
		}
	}
	public static void log(String str) {
		Gdx.app.log("MyTag", str);
		Gdx.app.log("MyTag", Gdx.app.getClass().getName());
		Gdx.app.log("MyTag", Gdx.app.getType().name());
		if (Gdx.app.getType().equals(ApplicationType.WebGL)) {
			console(str);
		}
	}
	
	public static native void console(String text)
	/*-{
	    console.log(text);
	}-*/;
}
