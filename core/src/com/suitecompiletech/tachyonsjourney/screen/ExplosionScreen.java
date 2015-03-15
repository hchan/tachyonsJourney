package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;
import com.suitecompiletech.tachyonsjourney.font.FontHelper;
import com.suitecompiletech.tachyonsjourney.font.FontParam;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonScreaming;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class ExplosionScreen extends BaseScreen {
	public static final String CAPTION_TEXT = "THE BIG BANG";
	private ParticleEffect effect;
	private BitmapFont font;
	private float stateTime;
	private long startTime = 0;
	private TachyonScreaming tachyonScreaming;
	private float multiplier = 1.0001f;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
	
	    stateTime += Gdx.graphics.getDeltaTime();  
		spriteBatch.begin();
		effect.draw(spriteBatch, delta);

	
		if (TimeUtils.timeSinceMillis(startTime) > 1500) {
			font.draw(spriteBatch, CAPTION_TEXT,
					(Gdx.graphics.getWidth() - font.getBounds(CAPTION_TEXT).width) / 2,
					(font.getBounds(CAPTION_TEXT).height) * 3);
		}

		if (TimeUtils.timeSinceMillis(startTime) > 5000
				&& GameUtil.startEventOnce("hasMusicStarted")) {
			
			Music music = TachyonsJourneyGame.assetManager.get("music/Loving Everything I Find.mp3", Music.class);
			music.play();
		}

		if (TimeUtils.timeSinceMillis(startTime) > 10000) {
			TextureRegion currentFrame = tachyonScreaming.getAnimation()
					.getKeyFrame(stateTime, true);
			float width = Gdx.graphics.getWidth()/10 *multiplier;
			float height = Gdx.graphics.getWidth()/10 * multiplier;
			float x = (Gdx.graphics.getWidth()-width)/2;
			float y = (Gdx.graphics.getHeight()-height)/2;
			
		
			Sprite sprite = new Sprite(currentFrame);
			sprite.setX(x);
			sprite.setY(y);
			sprite.setSize(width, height);
			sprite.setRotation(90f * multiplier);
			sprite.setOrigin(width/2, height/2);
			sprite.draw(spriteBatch);
			multiplier *= (TimeUtils.timeSinceMillis(startTime)/10000) * 1.01;

		}
		if (TimeUtils.timeSinceMillis(startTime) > 10000
				&& GameUtil.startEventOnce("tachyonScreamingSound")) {
			Sound sound = TachyonsJourneyGame.assetManager.get("sound/tachyonScreaming.ogg", Sound.class);
			sound.play(1, 0.9f, 0f);
		}
		
		// Gdx.app.log(ExplosionScreen.class.getSimpleName(), delta + "");
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	

	@Override
	public void show() {
		super.show();
		startTime = TimeUtils.millis();
		tachyonScreaming = new TachyonScreaming();
		Sound sound = TachyonsJourneyGame.assetManager.get("sound/explosion.mp3", Sound.class);
		sound.play();
		
		FontParam fontParam = new FontParam();
		fontParam.setTtfFileName("fonts/STONB___.TTF");
		fontParam.setText(CAPTION_TEXT);
		fontParam.setColor(Color.YELLOW);
		font = FontHelper.getTTF(fontParam);
		font.setScale(0.25f);
		effect = TachyonsJourneyGame.assetManager.get("effects/explosion.p", ParticleEffect.class);

		effect.setPosition(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		effect.start();
	}


	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		super.dispose();
		effect.dispose();
	}
}
