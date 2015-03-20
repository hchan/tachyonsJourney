package com.suitecompiletech.tachyonsjourney.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class HydrogenSprite extends Sprite {
	private RedBall redBall;
	private BlueBall blueBall;
	private float multiplier = 1.01f;
	
	public HydrogenSprite() {
		float width, height;
		redBall = new RedBall();
		width = Gdx.graphics.getWidth()/20;
		height = Gdx.graphics.getWidth()/20;
		redBall.setSize(width, height);
		redBall.setOriginCenter();//(width/2, height/2);
		redBall.setX((Gdx.graphics.getWidth()-redBall.getWidth())/2);
		redBall.setY((Gdx.graphics.getHeight()-redBall.getHeight())/2);
		
	
	
		
		 blueBall = new BlueBall();
		width = Gdx.graphics.getWidth()/80;
		height = Gdx.graphics.getWidth()/80;
		blueBall.setSize(width, height);
		blueBall.setOriginCenter();
		blueBall.setX((Gdx.graphics.getWidth()-blueBall.getWidth())/2);
		blueBall.setY((Gdx.graphics.getHeight()-blueBall.getHeight())/2);
	
	}
	
	public void render() {
		float rotation = 90f * multiplier;
		if (multiplier > 1.5) {
			multiplier = 1.01f;
		}
		redBall.setRotation(rotation);
		blueBall.setRotation(rotation);
		
	}
}
