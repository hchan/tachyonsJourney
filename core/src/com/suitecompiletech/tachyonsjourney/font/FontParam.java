package com.suitecompiletech.tachyonsjourney.font;

import com.badlogic.gdx.graphics.Color;

public class FontParam {
	private String ttfFileName;
	private String text;
	private Color color;
	public String getTtfFileName() {
		return ttfFileName;
	}
	public void setTtfFileName(String ttfFileName) {
		this.ttfFileName = ttfFileName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		FontParam objToCompare = (FontParam) obj;
		return this.getTtfFileName().equals(objToCompare.getTtfFileName()) &&
				this.getText().equals(objToCompare.getText()) &&
				this.getColor().equals(objToCompare.getColor());
	}
	
	@Override
	public int hashCode() {
		return (ttfFileName + text).hashCode() + color.hashCode();
	}
}
