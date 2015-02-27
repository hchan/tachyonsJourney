package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.suitecompiletech.tachyonsjourney.screen.ExplosionScreen;

public class TachyonsJourneyGame extends Game {
	
	
	@Override
	public void create () {
		setScreen(new ExplosionScreen());
	}

	@Override
	public void render () {
		super.render();
	}
}
