package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.suitecompiletech.tachyonsjourney.screen.TitleScreen;

public class TachyonsJourneyGame extends Game {
	public static AssetManager assetManager = new AssetManager();
	public static TachyonsJourneyGame game;
	public static Screen disposeScreen;

	@Override
	public void create() {
		Gdx.app.setLogLevel( com.badlogic.gdx.Application.LOG_DEBUG);
		game = this;
		AssetManagerHelper.loadAssets();
		assetManager.finishLoading();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setScreen(new TitleScreen());
		//setScreen(new SpaceScreen());
	}

	@Override
	public void render() {
		if (disposeScreen != null) {
			try {
				disposeScreen.dispose();
			} catch (Exception e) {
			}
			disposeScreen = null;
		}
		super.render();

	}

	public void doNewScreen(Screen newScreen, Screen oldScreen) {
		assetManager.finishLoading();
		setScreen(newScreen);
		disposeScreen = oldScreen;
	}
}
