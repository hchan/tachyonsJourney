package com.suitecompiletech.tachyonsjourney.font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*
 * Note the impl for this under the html project is different (damn GWT! - it doesn't support TTF)
 * FYI, to convert .ttf to .fnt, use http://kvazars.com/littera/
 */
public class FontHelper {
	public static BitmapFont getTTF(FontParam fontParam) {
		BitmapFont retval = null;
		retval = new BitmapFont(Gdx.files.internal("fonts/StoneyBilly.fnt"));
	
		GlyphLayout glyphLayout = new GlyphLayout();
		glyphLayout.setText(retval, fontParam.getText());
		retval.setColor(fontParam.getColor());
		return retval;
	}
}
