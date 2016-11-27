package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;
    private int hp;
    private float ang;
    private float size;

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        if (texture == null)
            texture = new Texture("asteroid60.tga");
        speed = 6.0f + (float) Math.random() * 3.0f;
        position = new Vector2(1280.0f + (float) Math.random() * 1280.0f, (float) Math.random() * 720.0f);
        rect = new Rectangle(position.x, position.y, 60, 60);
        hp = 3;
        ang = (float) Math.random() * 360.0f;
        size = 0.8f + (float)Math.random() * 0.4f;
    }

    public void render(SpriteBatch batch) {
        // batch.setColor(1, 1 - (3 - hp) * 0.3f, 1 - (3 - hp) * 0.3f, 1);
        //batch.draw(texture, position.x, position.y);
        batch.draw(texture, position.x, position.y, 30, 30, 60, 60, size, size, ang, 0, 0, 60, 60, false, false);
        // batch.setColor(1, 1, 1, 1);
    }

    public void recreate() {
        position.x = 1280.0f + (float) Math.random() * 1280;
        position.y = (float) Math.random() * 720;
        speed = 6.0f + (float) Math.random() * 3.0f;
        hp = 3;
        ang = (float) Math.random() * 360.0f;
        size = 0.5f + (float)Math.random() * 1.0f;
    }

    public void getDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            recreate();
        }
    }

    public void update() {
        position.x -= speed;
        rect.x = position.x;
        rect.y = position.y;
        ang += speed / 2;
        if (position.x < -60) {
            recreate();
        }
    }
}
