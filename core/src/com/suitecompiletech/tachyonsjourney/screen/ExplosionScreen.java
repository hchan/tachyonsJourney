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
import com.suitecompiletech.tachyonsjourney.sprite.TachyonScreaming;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class ExplosionScreen implements Screen {
	private SpriteBatch spriteBatch;
	private ParticleEffect effect;
	private BitmapFont font;
	private float stateTime;
	private long startTime = TimeUtils.millis();
	private TachyonScreaming tachyonScreaming;
	private float multiplier = 1.0001f;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
	
	    stateTime += Gdx.graphics.getDeltaTime();  
		spriteBatch.begin();
		effect.draw(spriteBatch, delta);

		String text = "THE BIG BANG";
		if (TimeUtils.timeSinceMillis(startTime) > 1500) {
			font.draw(spriteBatch, text,
					(Gdx.graphics.getWidth() - font.getBounds(text).width) / 2,
					(font.getBounds(text).height) * 3);
		}

		if (TimeUtils.timeSinceMillis(startTime) > 5000
				&& GameUtil.startEventOnce("hasMusicStarted")) {
			Music music = Gdx.audio.newMusic(Gdx.files
					.internal("music/Loving Everything I Find.mp3"));
			music.play();
		}

		if (TimeUtils.timeSinceMillis(startTime) > 10000) {
			TextureRegion currentFrame = tachyonScreaming.getAnimation()
					.getKeyFrame(stateTime, true);
			
			//currentFrame.setW
			//spriteBatch.draw(currentFrame, tachyonScreaming.getX(), tachyonScreaming.getY());
			//spriteBatch.draw(currentFrame, tachyonScreaming.getX(), tachyonScreaming.getY(), tachyonScreaming.getWidth(), tachyonScreaming.getHeight());
			
		
			float width = Gdx.graphics.getWidth()/10 *multiplier;
			float height = Gdx.graphics.getWidth()/10 * multiplier;
			float x = (Gdx.graphics.getWidth()-width)/2;
			float y = (Gdx.graphics.getHeight()-height)/2;
			
		
			Sprite sprite = new Sprite(currentFrame);
			sprite.setX(x);
			sprite.setY(y);
			sprite.setSize(width, height);
			//sprite.setScale(0.2f);
			sprite.setRotation(90f * multiplier);
			sprite.setOrigin(width/2, height/2);
			sprite.draw(spriteBatch);
			//spriteBatch.draw(currentFrame, x, y, originX, originY, width, height, scaleX, scaleY, rotation, true);
					
			multiplier *= (TimeUtils.timeSinceMillis(startTime)/10000) * 1.01;
			
			//tachyonScreaming.setWidth(tachyonScreaming.getWidth()* 1.005f);
			//tachyonScreaming.setHeight(tachyonScreaming.getHeight()* 1.005f);
			//tachyonScreaming.setSize(tachyonScreaming.getWidth()*1f, tachyonScreaming.getHeight()*1f);

		}
		// Gdx.app.log(ExplosionScreen.class.getSimpleName(), delta + "");
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	

	@Override
	public void show() {
		stateTime = 0f;
		tachyonScreaming = new TachyonScreaming();
		// Sound sound =
		// Gdx.audio.newSound(Gdx.files.internal("music/Loving Everything I Find.mp3"));
		Sound sound = Gdx.audio.newSound(Gdx.files
				.internal("sound/explosion.mp3"));
		sound.play();
		spriteBatch = new SpriteBatch();
		FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/STONB___.TTF"));
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
		spriteBatch.dispose();
		effect.dispose();
	}
}
