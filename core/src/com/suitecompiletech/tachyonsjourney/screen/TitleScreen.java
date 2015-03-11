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
import com.suitecompiletech.tachyonsjourney.sprite.TachyonScreaming;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class TitleScreen extends BaseScreen {
	
	private BitmapFont font;
	private boolean shrinkFont = false;
	private int initalFontSize = 2;
	private int curFontSize = 0;
	private float deltaTimeBeforeFlush = 0;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		deltaTimeBeforeFlush += delta;
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
	
	    stateTime += Gdx.graphics.getDeltaTime();  
		

		String text = "Tachyon's Journey";
		FreeTypeFontGenerator freeTypeFontGenerator = TachyonsJourneyGame.assetManager.get("fonts/STONB___.TTF", FreeTypeFontGenerator.class);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		if (curFontSize == 0) {
			curFontSize = initalFontSize;			
		} else {
			if (deltaTimeBeforeFlush > 0.005) {
				if (!shrinkFont) {
					curFontSize += 1;
				} else {
					curFontSize -= 1;
				}
				deltaTimeBeforeFlush = 0;
			}
		}
		parameter.size = curFontSize;
		parameter.color = Color.YELLOW;
		font = freeTypeFontGenerator.generateFont(parameter);
		spriteBatch.begin();
		font.draw(spriteBatch, text,
				(Gdx.graphics.getWidth() - font.getBounds(text).width) / 2,
				(Gdx.graphics.getHeight()) / 2);
		spriteBatch.end();
		if (font.getBounds(text).width >= Gdx.graphics.getWidth()) {
			shrinkFont = true;
		} else if (shrinkFont && curFontSize <= initalFontSize) {
			TachyonsJourneyGame.game.doNewScreen(new ExplosionScreen(), this);
		}
	}

	

}
