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
		BitmapFont retval = null;
		if (cache.get(fontParam) == null) {
			FreeTypeFontGenerator freeTypeFontGenerator = TachyonsJourneyGame.assetManager
					.get(fontParam.getTtfFileName(),
							FreeTypeFontGenerator.class);
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			boolean isTextWidthScreenSize = false;
			int fontSize = 16;
			while (!isTextWidthScreenSize) {

				parameter.size = fontSize;
				parameter.color = fontParam.getColor();
				retval = freeTypeFontGenerator.generateFont(parameter);

				if (retval.getBounds(fontParam.getText()).width > Gdx.graphics
						.getWidth()) {
					isTextWidthScreenSize = true;
				} else {
					retval.dispose();
					fontSize *= 2;
				}
			}
			cache.put(fontParam, retval);
		} else {
			retval = cache.get(fontParam);
		}

		return retval;
	}
}
