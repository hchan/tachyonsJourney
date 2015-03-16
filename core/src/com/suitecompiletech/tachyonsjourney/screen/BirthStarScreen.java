package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.sprite.BlueBall;
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
			redBall.setOriginCenter();//(width/2, height/2);
			redBall.setX((Gdx.graphics.getWidth()-redBall.getWidth())/2);
			redBall.setY((Gdx.graphics.getHeight()-redBall.getHeight())/2);
			float rotation = 90f * multiplier;
			if (multiplier > 1.5) {
				multiplier = 1.01f;
			}
			redBall.setRotation(rotation);
			
		
		
			
			BlueBall blueBall = new BlueBall();
			width = Gdx.graphics.getWidth()/80;
			height = Gdx.graphics.getWidth()/80;
			blueBall.setSize(width, height);
			blueBall.setOriginCenter();
			blueBall.setX((Gdx.graphics.getWidth()-blueBall.getWidth())/2);
			blueBall.setY((Gdx.graphics.getHeight()-blueBall.getHeight())/2);
			blueBall.setRotation(rotation);
			float theta = (float) (stateTime % 2*Math.PI);
			updateSpriteXYForEllipse(theta, redBall.getX() + redBall.getOriginX(), redBall.getY() + redBall.getOriginY(), 80, 40, blueBall);
			
		if (theta > 0.5 * Math.PI && theta < 1.5* Math.PI) {
			blueBall.draw(spriteBatch);
			redBall.draw(spriteBatch);
		} else {
			redBall.draw(spriteBatch);
			blueBall.draw(spriteBatch);
		}
			
			//spriteBatch.draw(redBall, (Gdx.graphics.getWidth()-redBall.getWidth())/2, (Gdx.graphics.getHeight()-redBall.getHeight())/2);
			spriteBatch.end();
	}
	
	
	  public void updateSpriteXYForEllipse(float theta, float xCenter, float yCenter, float xRadius, float yRadius, Sprite sprite) {
		  float x = (float) (xCenter + xRadius*Math.cos(theta));
		  float y = (float) (yCenter - yRadius*Math.sin(theta));
		  x -= sprite.getWidth()/2;
		  y -= sprite.getHeight()/2;
		  sprite.setX(x);
		  sprite.setY(y);
	   }
}
