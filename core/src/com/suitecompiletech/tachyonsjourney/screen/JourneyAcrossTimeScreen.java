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
	public static String CAPTION_TEXT = "As you journey across time";
	
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		effect.draw(spriteBatch, delta);
		drawText(CAPTION_TEXT, font);
		
		spriteBatch.end();
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
