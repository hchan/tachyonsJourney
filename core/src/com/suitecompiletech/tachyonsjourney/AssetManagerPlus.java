package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class AssetManagerPlus extends AssetManager {
	@Override
	public synchronized <T> T get(String fileName, Class<T> type) {
		try {
			return super.get(fileName, type);
		} catch (Exception e) {
			if (!isLoaded(fileName)) {
				if (type.equals(Sound.class)) {
					return (T) Gdx.audio.newSound(Gdx.files.internal(fileName));
				}
			} else {
				return super.get(fileName, type);
			}
		}
		return null;
	}
}
