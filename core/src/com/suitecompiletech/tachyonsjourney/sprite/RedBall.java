package com.suitecompiletech.tachyonsjourney.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RedBall extends Sprite {
	public RedBall() {
		Texture texture = new Texture(Gdx.files.internal("img/redBall.png"));
		this.setRegion(texture);
	}
}
