package com.suitecompiletech.tachyonsjourney.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		try {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			new LwjglApplication(new TachyonsJourneyGame(), config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
