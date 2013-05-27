package hk.jeffdev.mmotest;

import hk.jeffdev.actor.tank.Tank;
import hk.jeffdev.actor.tank.TankActionListener;
import hk.jeffdev.actor.tank.data.TankPara;
import hk.jeffdev.actor.tank.data.TankTypeSetting;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MMOTest implements ApplicationListener {
	
	private Stage stage;
	
	private Socket socket;
	private Tank tank;
	

	@Override
	public void create() {		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		tank = new Tank(new TankPara(100, 100, 0), new TankTypeSetting(200, 50, 20, "textureregion.png", 64, 25));
		stage.addActor(tank);
		
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.addListener(new TankActionListener(tank));

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(800, 600, false);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
