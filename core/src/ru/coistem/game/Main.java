package ru.coistem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	Stage stage;
	@Override
	public void create () {
		stage = new Stage();
	}

	@Override
	public void render () {
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {

	}
}
