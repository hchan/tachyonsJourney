package com.suitecompiletech.tachyonsjourney.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class BlueBall extends Sprite {
	public BlueBall() {
		Texture texture = new Texture(Gdx.files.internal("img/blueBall.png"));
		this.setRegion(texture);
	}
}
