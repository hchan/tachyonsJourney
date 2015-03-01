package com.suitecompiletech.tachyonsjourney.desktop;

import java.lang.Thread.UncaughtExceptionHandler;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		try {
			Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					e.printStackTrace();
				}
			});
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.width = 1024;
			config.height = 768;
			config.fullscreen = false;
			config.title = "Fcuk Cancer";
			config.addIcon("img/icon.png", FileType.Internal);
			
			
			new LwjglApplication(new TachyonsJourneyGame(), config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
