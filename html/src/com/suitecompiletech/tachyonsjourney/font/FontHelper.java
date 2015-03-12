package com.suitecompiletech.tachyonsjourney.font;

import java.util.HashMap;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.suitecompiletech.tachyonsjourney.TachyonsJourneyGame;

public class FontHelper {

	public static HashMap<FontParam, BitmapFont> cache = new HashMap<FontParam, BitmapFont>();

	public static BitmapFont getTTF(FontParam fontParam) {
		BitmapFont retval = new BitmapFont();
		if (cache.get(fontParam) == null) {
		
		
			cache.put(fontParam, retval);
		} else {
			retval = cache.get(fontParam);
		}

		return retval;
	}
}
