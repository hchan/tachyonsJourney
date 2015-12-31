package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.suitecompiletech.tachyonsjourney.font.FontHelper;
import com.suitecompiletech.tachyonsjourney.font.FontParam;

public class BaseScreen implements Screen {
	protected SpriteBatch spriteBatch;
	protected float stateTime;
	protected long startTime = 0;
	protected GlyphLayout glyphLayout = new GlyphLayout();
	
	@Override
	public void show() {
		stateTime = 0f;
		spriteBatch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
	
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

	private void drawText(String captionText, BitmapFont font, float widthRatio, float heightRatio) {
		glyphLayout.setText(font, captionText);
		font.draw(spriteBatch, captionText,
				(Gdx.graphics.getWidth() - glyphLayout.width) / widthRatio,
				(glyphLayout.height) * heightRatio);
	}

	public void drawText(String captionText, BitmapFont font) {
		drawText(captionText, font, 2f, 3f);
	}
	
	public BitmapFont getFont(String captionText) {
		return getFont(captionText, 0.25f);
	}
	public BitmapFont getFont(String captionText, float scale) {
		FontParam fontParam = new FontParam();
		fontParam.setTtfFileName("fonts/STONB___.TTF");
		fontParam.setText(captionText);
		fontParam.setColor(Color.YELLOW);
		BitmapFont font = FontHelper.getTTF(fontParam);
		font.getData().setScale(scale);
		return font;
	}
}
