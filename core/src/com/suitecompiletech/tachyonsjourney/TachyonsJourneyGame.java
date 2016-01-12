package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.suitecompiletech.tachyonsjourney.screen.BlackHoleScreen;
import com.suitecompiletech.tachyonsjourney.screen.TitleScreen;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class TachyonsJourneyGame extends Game {
	public static AssetManager assetManager = new AssetManager();
	public static TachyonsJourneyGame game;
	public static Screen disposeScreen;

	@Override
	public void create() {
		Gdx.app.setLogLevel( com.badlogic.gdx.Application.LOG_DEBUG);
		game = this;
		GameUtil.log("About to loadAssets from TachyonsJourneyGame");
		if (!Gdx.app.getType().equals(ApplicationType.WebGL)) {
			AssetManagerFontLoading.loadAssets();
		}
		AssetManagerHelper.loadAssets();
		GameUtil.log("finishLoading");
		assetManager.finishLoading();
	
		setScreen(new TitleScreen());
		//setScreen(new BlackHoleScreen());
	}

	@Override
	public void render() {
		assetManager.finishLoading();
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
