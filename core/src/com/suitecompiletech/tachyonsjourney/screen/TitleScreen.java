package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;
import com.suitecompiletech.tachyonsjourney.font.FontHelper;
import com.suitecompiletech.tachyonsjourney.font.FontParam;

public class TitleScreen extends BaseScreen {
	
	public static final String CAPTION_TEXT = "Tachyon's Journey";
	private BitmapFont font;
	private boolean shrinkFont = false;
	private float initalFontScale = 0.1f;
	private float curFontScale = 0f;
	private float deltaTimeBeforeFlush = 0;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		deltaTimeBeforeFlush += delta;
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
	
	    stateTime += Gdx.graphics.getDeltaTime();  
		

	
		if (curFontScale == 0) {
			curFontScale = initalFontScale;			
		} else {
			//if (deltaTimeBeforeFlush > 0.5) {
			
				float scaleVelocity = 0.01f;
				if (Gdx.app.getType().equals(ApplicationType.WebGL)) {
					scaleVelocity = 0.1f;
				}
				
				if (!shrinkFont) {
					curFontScale += scaleVelocity;
				} else {
					curFontScale -= scaleVelocity;
				}
				deltaTimeBeforeFlush = 0;
			//}
		}
		
		FontParam fontParam = new FontParam();
		fontParam.setTtfFileName("fonts/STONB___.TTF");
		fontParam.setText(CAPTION_TEXT);
		fontParam.setColor(Color.YELLOW);
		font = FontHelper.getTTF(fontParam);
		font.setScale(curFontScale);
		if (curFontScale >= 1) {
			shrinkFont = true;
			return;
		} else if (shrinkFont && curFontScale <= initalFontScale) {
			TachyonsJourneyGame.game.doNewScreen(new ExplosionScreen(), this);
		}
		
		
		spriteBatch.begin();
		font.draw(spriteBatch, CAPTION_TEXT,
				(Gdx.graphics.getWidth() - font.getBounds(CAPTION_TEXT).width) / 2,
				(Gdx.graphics.getHeight()) / 2);
		//font.dispose();
		spriteBatch.end();
		
	}

	

}
