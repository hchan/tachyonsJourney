package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;
import com.suitecompiletech.tachyonsjourney.sprite.HydrogenSprite;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;

public class JourneyThroughScreen extends BaseScreen {
	private TachyonWatching tachyonWatching = new TachyonWatching();
	private HydrogenSprite hydrogenSprite1 = new HydrogenSprite(0,0);
	private HydrogenSprite hydrogenSprite2 = new HydrogenSprite(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
	private ParticleEffect effect;
	private BitmapFont font;
	public static String CAPTION_TEXT = "Cosmic Inflation has begun";
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Sprite sprite = null;

		long timeSinceMillis = TimeUtils.timeSinceMillis(startTime);
		// if (TimeUtils.timeSinceMillis(startTime) > 10000) {
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
		hydrogenSprite1.render(delta);
		hydrogenSprite2.render(delta);
		hydrogenSprite1.draw(spriteBatch);
		hydrogenSprite2.draw(spriteBatch);
		drawText(CAPTION_TEXT, font);
		// collision
		if (hydrogenSprite1.isVisible() && hydrogenSprite1.getRedBall().getBoundingRectangle().overlaps(hydrogenSprite2.getRedBall().getBoundingRectangle())) {
			
			if (effect == null) {
				effect = TachyonsJourneyGame.assetManager.get("effects/hydrogenCollision.p", ParticleEffect.class);
				effect.setPosition(hydrogenSprite1.getRedBall().getX(),
						hydrogenSprite1.getRedBall().getY());
				effect.start();
				effect.setDuration(1500);
				hydrogenSprite1.setVisible(false);
				hydrogenSprite2.setVisible(false);
				Sound sound = TachyonsJourneyGame.assetManager.get("sound/mediumExplosion.ogg", Sound.class);
				sound.play(1, 0.9f, 0f);
				
			}
		}
		if (effect != null && !effect.isComplete()) {
			effect.draw(spriteBatch, delta);
			//effect.update(delta);
		}
		if (effect != null && effect.isComplete()) {
			effect.dispose();
			effect = null;
		}
		spriteBatch.end();
	}
	
	
	@Override
	public void show() {
		super.show();
		startTime = TimeUtils.millis();
		font = getFont(CAPTION_TEXT, 0.5f);
	}
	
}
