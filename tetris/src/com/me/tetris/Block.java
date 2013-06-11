package com.me.tetris;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class Block {
	float x=0;
	float y=0;
	Sprite sprite;
	Tetris main;

	public Block(Tetris mainInst, Array<Sprite> sprites, TextureRegion region){
		main=mainInst;
		sprite = new Sprite(region);
		sprites.add(sprite);
		sprites.get(0).setSize(1f, 1f);
		//setPos(x,y);
	}
	
	public void setPos(float inX, float inY) {
		Vector3 vec = main.fixCoord(inX, inY);
		this.x = vec.x;
		this.y = vec.y;
		main.sprites.get(0).setPosition(this.x,this.y);
	}
}
