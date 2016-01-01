package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.suitecompiletech.tachyonsjourney.font.FontHelper;
import com.suitecompiletech.tachyonsjourney.font.FontParam;
import com.suitecompiletech.tachyonsjourney.screen.BigBangScreen;
import com.suitecompiletech.tachyonsjourney.screen.TitleScreen;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class AssetManagerHelper {
	
	public static void loadAssets() {
		// set the loaders for the generator and the fonts themselves
		FileHandleResolver resolver = new InternalFileHandleResolver();
		TachyonsJourneyGame.assetManager.setLoader(FreeTypeFontGenerator.class,
				new FreeTypeFontGeneratorLoader(resolver));
		TachyonsJourneyGame.assetManager.setLoader(BitmapFont.class, ".ttf",
				new FreetypeFontLoader(resolver));
		TachyonsJourneyGame.assetManager.load("fonts/STONB___.TTF",
				FreeTypeFontGenerator.class);
		
		TachyonsJourneyGame.assetManager.finishLoading();
		// load certain fonts
		FontParam fontParam = new FontParam();
		fontParam.setTtfFileName("fonts/STONB___.TTF");
		fontParam.setText(TitleScreen.CAPTION_TEXT);
		fontParam.setColor(Color.YELLOW);
		FontHelper.getTTF(fontParam);
		
		fontParam = new FontParam();
		fontParam.setTtfFileName("fonts/STONB___.TTF");
		fontParam.setText(BigBangScreen.CAPTION_TEXT);
		fontParam.setColor(Color.YELLOW);
		FontHelper.getTTF(fontParam);
		
		GameUtil.log("Inside loadAssets");
		TachyonsJourneyGame.assetManager.load("music/Loving Everything I Find.mp3", Music.class);
		TachyonsJourneyGame.assetManager.load("sound/explosion.mp3", Sound.class);
		TachyonsJourneyGame.assetManager.load("sound/tachyonScreaming.ogg", Sound.class);
		TachyonsJourneyGame.assetManager.load("sound/mediumExplosion.ogg", Sound.class);
		
		
		TachyonsJourneyGame.assetManager.load("effects/explosion.p", ParticleEffect.class);
		TachyonsJourneyGame.assetManager.load("effects/hydrogenCollision.p", ParticleEffect.class);
		TachyonsJourneyGame.assetManager.load("effects/stars.p", ParticleEffect.class);
		
		TachyonsJourneyGame.assetManager.load("blender/sphere.g3dj", Model.class);
		GameUtil.log("leaving loadAssets");
	}
}
