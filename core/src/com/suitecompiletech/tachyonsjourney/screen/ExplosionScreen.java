package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.utils.TimeUtils;

public class ExplosionScreen implements Screen {
	private SpriteBatch batch;
	private ParticleEffect effect;
	private BitmapFont font;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		effect.draw(batch, delta);

		String text = "THE BIG BANG";
		if (TimeUtils.timeSinceMillis(startTime) > 1500) {
			font.draw(
					batch,
					text,
					(Gdx.graphics.getWidth() - font.getBounds(text).width) / 2,
					(font.getBounds(text).height) * 3);
		}
		//Gdx.app.log(ExplosionScreen.class.getSimpleName(), delta + "");
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	private long startTime = TimeUtils.millis();

	@Override
	public void show() {

		batch = new SpriteBatch();
		FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/STONB___.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 34;
		parameter.color = Color.YELLOW;
		font = freeTypeFontGenerator.generateFont(parameter);
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("effects/explosion.p"),
				Gdx.files.internal("img"));
		effect.setPosition(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		effect.start();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		effect.dispose();
	}
}
