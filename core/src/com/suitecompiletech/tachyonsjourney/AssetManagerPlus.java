package com.suitecompiletech.tachyonsjourney;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
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
				} else if (type.equals(Music.class)) {
					return (T) Gdx.audio.newMusic(Gdx.files.internal(fileName));
				} else if (type.equals(ParticleEffect.class)) {
					ParticleEffect particleEffect = new ParticleEffect();
					particleEffect.load(Gdx.files.internal(fileName), Gdx.files.internal(""));
					return (T) particleEffect;
				} else if (type.equals(Model.class)) {
					  ModelLoader loader = new ObjLoader();
					  return (T) loader.loadModel(Gdx.files.internal(fileName));
				}
			} else {
				return super.get(fileName, type);
			}
		}
		return super.get(fileName, type);
	}
}
