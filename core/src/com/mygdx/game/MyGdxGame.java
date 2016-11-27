package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Hero hero;
	private final int AST_COUNT = 20;
	Asteroid[] asteroids;
	final int BULLETS_COUNT = 50;
	public  static Bullet[] bullets;
	private Texture texBullet;
	private final int MAX_FXES = 20;
	public static MyFX[] fxes;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		asteroids = new Asteroid[AST_COUNT];
		for (int i = 0; i < AST_COUNT; i++) {
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[BULLETS_COUNT];
		for (int i = 0; i < BULLETS_COUNT; i++) {
			bullets[i] = new Bullet();
		}
		texBullet = new Texture("bullet20.png");
		fxes = new MyFX[MAX_FXES];
		for (int i = 0; i < MAX_FXES; i++) {
			fxes[i] = new MyFX();
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		for (int i = 0; i < AST_COUNT; i++) {
			asteroids[i].render(batch);
		}
		hero.render(batch);
		for (int i = 0; i < BULLETS_COUNT; i++) {
			if (bullets[i].isActive())
				batch.draw(texBullet, bullets[i].getPosition().x, bullets[i].getPosition().y);
		}
		for (int i = 0; i < MAX_FXES; i++) {
			fxes[i].render(batch);
		}
		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for (int i = 0; i < AST_COUNT; i++) {
			asteroids[i].update();
		}
		for (int i = 0; i < BULLETS_COUNT; i++) {
			if (bullets[i].isActive())
				bullets[i].update();
		}
		for (int i = 0; i < BULLETS_COUNT; i++) {
			if (bullets[i].isActive()) {
				for (int j = 0; j < AST_COUNT; j++) {
					if (asteroids[j].getRect().contains(bullets[i].getPosition())) {
						asteroids[i].recreate();
						bullets[i].destroy();

						for (int k = 0; k < MAX_FXES; k++) {
							if (!fxes[k].isActive()) {
								fxes[k].setup(bullets[i].getPosition().x, bullets[i].getPosition().y);
								break;
							}
						}

						break;
					}
				}
			}
		}
		for (int i = 0; i < MAX_FXES; i++) {
			fxes[i].update();
		}
	}
}
