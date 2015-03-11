package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class FontHelper {
	public static BitmapFont generateFont(String ttfFileName, int fontSize, Color color) {
		BitmapFont retval = new BitmapFont();
		retval.scale(fontSize/30);
		retval.setColor(color);
		return retval;
	}
}
