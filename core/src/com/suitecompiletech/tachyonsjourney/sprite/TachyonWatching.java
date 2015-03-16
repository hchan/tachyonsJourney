package com.suitecompiletech.tachyonsjourney.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TachyonWatching extends AnimationSprite {

	

	public TachyonWatching() {
		Texture texture = new Texture(Gdx.files.internal("img/spritemap/tachyonWatching.png"));
		
		
		TextureRegion[] keyFrames = TextureRegion.split(texture, 400, 400)[0];
//		 width = Gdx.graphics.getWidth()/10;
//		 height = Gdx.graphics.getHeight()/10;
//		 
//		 x = (Gdx.graphics.getWidth()-width)/2;
//		 y = (Gdx.graphics.getHeight()-height)/2;
		animation = new Animation(0.1f, keyFrames);
		
	
	}

	
	
}
