package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.suitecompiletech.tachyonsjourney.screen.ExplosionScreen;

public class TachyonsJourneyGame extends Game {
	public static AssetManager assetManager = new AssetManager();
	
	@Override
	public void create () {
	
		setScreen(new ExplosionScreen());
	}

	@Override
	public void render () {
		super.render();
	}
}
