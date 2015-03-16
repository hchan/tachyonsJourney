package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.suitecompiletech.tachyonsjourney.screen.BirthStarScreen;
import com.suitecompiletech.tachyonsjourney.screen.ExplosionScreen;
import com.suitecompiletech.tachyonsjourney.screen.TitleScreen;

public class TachyonsJourneyGame extends Game {
	public static AssetManager assetManager = new AssetManager();
	public static TachyonsJourneyGame game;
	public static Screen disposeScreen;

	@Override
	public void create() {
		game = this;
		AssetManagerHelper.loadAssets();
		

		

		assetManager.finishLoading();
//		setScreen(new TitleScreen());
//		setScreen(new ExplosionScreen());
		setScreen(new BirthStarScreen());
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
