package com.suitecompiletech.tachyonsjourney.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.Random;

public class HydrogenSprite extends Sprite {
	private RedBall redBall;
	private BlueBall blueBall;
	private float multiplier = 1.01f;
	private float theta;
	private float velocity;
	private Random rand = new Random();
	private float ellipseRotation;

	public HydrogenSprite() {

		velocity = rand.nextFloat() * 2 + 1.5f;
		ellipseRotation = (float) (rand.nextFloat() * 2 * Math.PI);
		float width, height;
		redBall = new RedBall();
		width = Gdx.graphics.getWidth() / 40;
		height = Gdx.graphics.getWidth() / 40;
		redBall.setSize(width, height);
		redBall.setOriginCenter();// (width/2, height/2);
		redBall.setX((Gdx.graphics.getWidth() - redBall.getWidth()) / 2);
		redBall.setY((Gdx.graphics.getHeight() - redBall.getHeight()) / 2);

		blueBall = new BlueBall();
		width = Gdx.graphics.getWidth() / 80;
		height = Gdx.graphics.getWidth() / 80;
		blueBall.setSize(width, height);
		blueBall.setOriginCenter();
		blueBall.setX((Gdx.graphics.getWidth() - blueBall.getWidth()) / 2);
		blueBall.setY((Gdx.graphics.getHeight() - blueBall.getHeight()) / 2);

	}

	@Override
	public void draw(Batch batch) {
		if (theta > 0.5 * Math.PI && theta < velocity * Math.PI) {
			blueBall.draw(batch);
			redBall.draw(batch);
		} else {
			redBall.draw(batch);
			blueBall.draw(batch);
		}
	}

	public void render(float stateTime) {
		theta = (float) (stateTime * 2 % 2 * Math.PI);
		updateSpriteXYForEllipse(theta, redBall.getX() + redBall.getOriginX(),
				redBall.getY() + redBall.getOriginY(), 80, 40, blueBall);

		float rotation = 90f * multiplier;
		if (multiplier > 1.5) {
			multiplier = 1.01f;
		}
		redBall.setRotation(rotation);
		blueBall.setRotation(rotation);

	}

	// http://www.uwgb.edu/dutchs/Geometry/HTMLCanvas/ObliqueEllipses5.HTM
	public void updateSpriteXYForEllipse(float theta, float xCenter,
			float yCenter, float xRadius, float yRadius, Sprite sprite) {
		float x = (float) (xCenter + ((xRadius * Math.cos(theta)) * Math.cos(ellipseRotation) - yRadius * Math.sin(theta) * Math.sin(ellipseRotation)));
		float y = (float) (yCenter - ((yRadius * Math.sin(theta)) * Math.cos(ellipseRotation) + xRadius * Math.cos(theta) * Math.sin(ellipseRotation)));
		x -= sprite.getWidth() / 2;
		y -= sprite.getHeight() / 2;
		sprite.setX(x);
		sprite.setY(y);
	}

	public RedBall getRedBall() {
		return redBall;
	}

	public void setRedBall(RedBall redBall) {
		this.redBall = redBall;
	}

	public BlueBall getBlueBall() {
		return blueBall;
	}

	public void setBlueBall(BlueBall blueBall) {
		this.blueBall = blueBall;
	}

	public float getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(float multiplier) {
		this.multiplier = multiplier;
	}

	public float getTheta() {
		return theta;
	}

	public void setTheta(float theta) {
		this.theta = theta;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	
}
