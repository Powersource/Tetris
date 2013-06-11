package com.me.tetris;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class Tetromino {
	float x = 0;
	float y = 0;
	Tetris main;
	Block block;

	public Tetromino(Tetris mainInst, Array<Sprite> sprites,
			TextureRegion region) {
		// kolla upp om jag borde extenda Block h�r^
		// tror inte det

		// placera Block relativt x och y med hj�lp av en method i Block.java
		// Tetrominons position s�tts med hj�lp av setPos h�r under
		main = mainInst;
		block = new Block(main, sprites, region);

	}

	public void setPos(float inX, float inY) {
		Vector3 vec = main.fixCoord(inX, inY);
		this.x = vec.x;
		this.y = vec.y;
		block.setPos(this.x, this.y);
	}
}
