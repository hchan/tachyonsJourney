package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;
import com.suitecompiletech.tachyonsjourney.sprite.HydrogenSprite;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class JourneyAcrossTimeScreen extends BaseScreen {
	
	private ParticleEffect effect;
	private BitmapFont font;
	public static String CAPTION_TEXT = "Journey across time";
	private TachyonWatching tachyonWatching = new TachyonWatching();
	
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Sprite sprite = null;

		long timeSinceMillis = TimeUtils.timeSinceMillis(startTime);
		TextureRegion currentFrame = tachyonWatching.getAnimation()
				.getKeyFrame(((int)(timeSinceMillis/1000)) % 4, true);
		float width = Gdx.graphics.getWidth() / 10;
		float height = Gdx.graphics.getWidth() / 10;
		float x = (Gdx.graphics.getWidth() - width) / 8;
		float y = (Gdx.graphics.getHeight() - 2 * height);

		x += timeSinceMillis/5;
		y -= timeSinceMillis/20;
				
		sprite = new Sprite(currentFrame);
		sprite.setX(x);
		sprite.setY(y);
		sprite.setSize(width, height);
		// sprite.setRotation(90f * multiplier);
		sprite.setOrigin(width / 2, height / 2);
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		effect.draw(spriteBatch, delta);
		drawText(CAPTION_TEXT, font);
		spriteBatch.end();
		if (sprite != null && sprite.getX() >= Gdx.graphics.getWidth()) {
			TachyonsJourneyGame.game.doNewScreen(new SpaceScreen(), this);
		}
	}
	
	
	@Override
	public void show() {
		super.show();
		super.show();
		startTime = TimeUtils.millis();
		
		
		effect = TachyonsJourneyGame.assetManager.get("effects/stars.p", ParticleEffect.class);

		effect.setPosition(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		effect.start();
		font = getFont(CAPTION_TEXT, 0.5f);
	}
	
}
