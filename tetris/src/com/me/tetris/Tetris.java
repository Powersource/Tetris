package com.me.tetris;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class Tetris implements ApplicationListener {
	OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	//behövs den här arrayen? block kan ta hand om dem själv väl
	public Array<Sprite> sprites = new Array<Sprite>();
	// gör till en array
	Tetromino tetromino;
	float w;
	float h;
	float setX=0;

	@Override
	public void create() {
		// pixelmåttet på fönstret ställs delvis in i mainfilen
		Gdx.graphics.setTitle("Tetris");

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, h / w);
		batch = new SpriteBatch();

		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);

		tetromino = new Tetromino(this, sprites, region);
		//tetromino.setPos(0, 0);
		
		camera.lookAt(1f, 1f, 1f);
		camera.update();
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {
		
		/*if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) setX+=0.01;
		tetromino.setPos(setX, 0);
		System.out.println(setX);*/
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.lookAt(setX, 1f, -1f);
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		sprites.get(0).setPosition(setX+=0.001,0);
		System.out.println("setX: "+setX);
		System.out.println("fixCoord: "+fixCoord(setX, 0).x);
		
		for (Sprite s : sprites) {
			s.draw(batch);
		}
		batch.end();
	}

	public Vector3 fixCoord(float x, float y) {
		Vector3 vec = new Vector3(x, y, 0);
		camera.unproject(vec);
		return vec;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
