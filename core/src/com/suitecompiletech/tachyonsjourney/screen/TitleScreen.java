package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.suitecompiletech.tachyonsjourney.FontHelper;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;

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
		
		font = FontHelper.generateFont("fonts/STONB___.TTF", curFontSize, Color.YELLOW);
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
