package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen {
	protected SpriteBatch spriteBatch;
	protected float stateTime;
	
	@Override
	public void show() {
		stateTime = 0f;
		spriteBatch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		stateTime += Gdx.graphics.getDeltaTime();  
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

}
