package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.suitecompiletech.tachyonsjourney.sprite.HydrogenSprite;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;

public class BirthStarScreen extends BaseScreen {
	private TachyonWatching tachyonWatching = new TachyonWatching();
	private HydrogenSprite hydrogenSprite1 = new HydrogenSprite();

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
		hydrogenSprite1.render(stateTime);
		hydrogenSprite1.draw(spriteBatch);
		hydrogenSprite1.getRedBall().setX(hydrogenSprite1.getRedBall().getX()+1);
		hydrogenSprite1.getRedBall().setY(hydrogenSprite1.getRedBall().getY()+1);
		spriteBatch.end();
	}
	
	
	@Override
	public void show() {
		super.show();
		hydrogenSprite1.getRedBall().setX(0);
		hydrogenSprite1.getRedBall().setY(0);
	}
	
}
