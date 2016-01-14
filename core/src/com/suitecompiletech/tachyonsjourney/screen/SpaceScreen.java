package com.suitecompiletech.tachyonsjourney.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;
import com.suitecompiletech.tachyonsjourney.sprite.TachyonWatching;

public class SpaceScreen extends BaseScreen {

	private BitmapFont font;
	public static String CAPTION_TEXT = "And Space";
	private TachyonWatching tachyonWatching = new TachyonWatching();
	private ModelBatch modelBatch = new ModelBatch();
	private ModelInstance sphereModelInstance;
	private Model sphereModel;
	private ModelInstance terryModelInstance;
	private Model terryModel;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);
		camera.update();
		controller.update();

		Sprite sprite = null;

		long timeSinceMillis = TimeUtils.timeSinceMillis(startTime);
		TextureRegion currentFrame = tachyonWatching.getAnimation()
				.getKeyFrame(((int) (timeSinceMillis / 1000)) % 4, true);
		float width = Gdx.graphics.getWidth() / 10;
		float height = Gdx.graphics.getWidth() / 10;
		float x = (Gdx.graphics.getWidth() - width) / 8;
		float y = (Gdx.graphics.getHeight() - 2 * height);

		x += timeSinceMillis / 5;
		y -= timeSinceMillis / 20;

		sprite = new Sprite(currentFrame);
		sprite.setX(x);
		sprite.setY(y);
		sprite.setSize(width, height);
		// sprite.setRotation(90f * multiplier);
		sprite.setOrigin(width / 2, height / 2);

		modelBatch.begin(camera);

		sphereModelInstance.transform.rotate(Vector3.X, 0.1f);
		sphereModelInstance.transform.rotate(Vector3.Y, 0.1f);
		sphereModelInstance.transform.rotate(Vector3.Z, 0.1f);
		sphereModelInstance.transform.scl(1.005f);
		
		terryModelInstance.transform.scl(1.005f);
		modelBatch.render(terryModelInstance, environment);
		//modelBatch.render(sphereModelInstance, environment);

		modelBatch.end();

		spriteBatch.begin();
		sprite.draw(spriteBatch);
		drawText(CAPTION_TEXT, font);
		spriteBatch.end();
		if (sprite != null && sprite.getX() >= Gdx.graphics.getWidth()) {
			TachyonsJourneyGame.game.doNewScreen(new BlackHoleScreen(), this);
		}
	}

	@Override
	public void show() {
		super.show();
		startTime = TimeUtils.millis();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f,
				0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f,
				-0.8f, -0.2f));
		camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		// Move the camera 5 units back along the z-axis and look at the origin
		camera.position.set(0f, 0f, 7f);
		camera.lookAt(0f, 0f, 0f);

		// Near and Far (plane) represent the minimum and maximum ranges of the
		// camera in, um, units
//		camera.near = 0.1f;
//		camera.far = 300.0f;

	
		sphereModel = TachyonsJourneyGame.assetManager.get("blender/sphere.g3dj", Model.class);
		sphereModelInstance = new ModelInstance(sphereModel);
		sphereModelInstance.transform.scale(.010f, .010f, .010f);
		
		terryModel = TachyonsJourneyGame.assetManager.get("blender/terry.g3dj", Model.class);
		terryModelInstance = new ModelInstance(terryModel);
		terryModelInstance.transform.scale(0.010f, 0.010f, 0.010f);
		
		controller = new CameraInputController(camera);
		Gdx.input.setInputProcessor(controller);
		
		font = getFont(CAPTION_TEXT, 0.25f);
	}

}
