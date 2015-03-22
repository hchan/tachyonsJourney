package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.suitecompiletech.tachyonsjourney.sprite.HydrogenSprite;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;

public class BirthStarScreen extends BaseScreen {
	private TachyonWatching tachyonWatching = new TachyonWatching();
	private HydrogenSprite hydrogenSprite1 = new HydrogenSprite(0,0);
	private HydrogenSprite hydrogenSprite2 = new HydrogenSprite(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Sprite sprite = null;

		// if (TimeUtils.timeSinceMillis(startTime) > 10000) {
		TextureRegion currentFrame = tachyonWatching.getAnimation()
				.getKeyFrame(1, true);
		float width = Gdx.graphics.getWidth() / 10;
		float height = Gdx.graphics.getWidth() / 10;
		float x = (Gdx.graphics.getWidth() - width) / 8;
		float y = (Gdx.graphics.getHeight() - 2 * height);

		sprite = new Sprite(currentFrame);
		sprite.setX(x);
		sprite.setY(y);
		sprite.setSize(width, height);
		// sprite.setRotation(90f * multiplier);
		sprite.setOrigin(width / 2, height / 2);
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		hydrogenSprite1.render(delta);
		hydrogenSprite2.render(delta);
		hydrogenSprite1.draw(spriteBatch);
		hydrogenSprite2.draw(spriteBatch);
		
		if (hydrogenSprite1.getRedBall().getBoundingRectangle().overlaps(hydrogenSprite2.getRedBall().getBoundingRectangle())) {
			System.out.println("COLLISION");
		}
		spriteBatch.end();
	}
	
	
	@Override
	public void show() {
		super.show();
		
	}
	
}
