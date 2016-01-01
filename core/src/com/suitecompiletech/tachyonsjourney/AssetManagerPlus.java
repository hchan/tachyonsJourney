package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.assets.AssetManager;
import com.suitecompiletech.tachyonsjourney.util.GameUtil;

public class AssetManagerPlus extends AssetManager {
	@Override
	public synchronized <T> T get(String fileName, Class<T> type) {
		try {
			return super.get(fileName, type);
		} catch (Exception e) {
			if (!isLoaded(fileName)) {
				this.load(fileName, type);
				GameUtil.log("still loading " + fileName);
			}
			return super.get(fileName, type);
		}
	}
}
