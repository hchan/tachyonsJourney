package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class AssetManagerHelper {
	public static void loadAssets() {
		// set the loaders for the generator and the fonts themselves
				FileHandleResolver resolver = new InternalFileHandleResolver();
				TachyonsJourneyGame.assetManager.setLoader(FreeTypeFontGenerator.class,
						new FreeTypeFontGeneratorLoader(resolver));
				TachyonsJourneyGame.assetManager.setLoader(BitmapFont.class, ".ttf",
						new FreetypeFontLoader(resolver));
				TachyonsJourneyGame.assetManager.load("fonts/STONB___.TTF", FreeTypeFontGenerator.class);
	}
}
