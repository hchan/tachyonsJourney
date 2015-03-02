package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.suitecompiletech.tachyonsjourney.screen.ExplosionScreen;

public class TachyonsJourneyGame extends Game {
	public static AssetManager assetManager = new AssetManager();
	public static TachyonsJourneyGame game;
	
	@Override
	public void create () {
		game = this;
		assetManager.load("music/Loving Everything I Find.mp3", Music.class);
		assetManager.finishLoading();
		setScreen(new ExplosionScreen());
	}

	@Override
	public void render () {
		super.render();
	}
}
