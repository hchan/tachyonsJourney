package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class FontHelper {
	public static BitmapFont generateFont(String ttfFileName, int fontSize, Color color) {
		FreeTypeFontGenerator freeTypeFontGenerator = TachyonsJourneyGame.assetManager.get(ttfFileName, FreeTypeFontGenerator.class);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		
		parameter.size = fontSize;
		parameter.color = color;
		return freeTypeFontGenerator.generateFont(parameter);
	}
}
