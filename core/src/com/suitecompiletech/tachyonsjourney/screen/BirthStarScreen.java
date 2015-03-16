package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.sprite.RedBall;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;

public class BirthStarScreen extends BaseScreen {
	private TachyonWatching tachyonWatching = new TachyonWatching();
	private float multiplier = 1.01f;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Sprite sprite = null;
		multiplier *= 1.01f;
		
		//if (TimeUtils.timeSinceMillis(startTime) > 10000) {
			TextureRegion currentFrame = tachyonWatching.getAnimation()
					.getKeyFrame(1, true);
			float width = Gdx.graphics.getWidth()/10;
			float height = Gdx.graphics.getWidth()/10;
			float x = (Gdx.graphics.getWidth()-width)/8;
			float y = (Gdx.graphics.getHeight()-2*height);
			
		
			sprite = new Sprite(currentFrame);
			sprite.setX(x);
			sprite.setY(y);
			sprite.setSize(width, height);
			//sprite.setRotation(90f * multiplier);
			sprite.setOrigin(width/2, height/2);
			spriteBatch.begin();
			sprite.draw(spriteBatch);
			
			//multiplier *= (TimeUtils.timeSinceMillis(startTime)/10000) * 1.01;

		//}
			
			
			RedBall redBall = new RedBall();
			width = Gdx.graphics.getWidth()/20;
			height = Gdx.graphics.getWidth()/20;
			redBall.setSize(width, height);
			redBall.setOrigin(width/2, height/2);
			redBall.setX((Gdx.graphics.getWidth()-redBall.getWidth())/2);
			redBall.setY((Gdx.graphics.getHeight()-redBall.getHeight())/2);
			float rotation = 90f * multiplier;
			if (multiplier > 1.5) {
				multiplier = 1.01f;
			}
			redBall.setRotation(rotation);
			redBall.draw(spriteBatch);
			//spriteBatch.draw(redBall, (Gdx.graphics.getWidth()-redBall.getWidth())/2, (Gdx.graphics.getHeight()-redBall.getHeight())/2);
			spriteBatch.end();
	}
}
