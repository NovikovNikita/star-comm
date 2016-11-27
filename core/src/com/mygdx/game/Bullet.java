package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Никита on 27.11.2016.
 */
public class Bullet {
    private Vector2 position;
    private float speed;
    private boolean active;

    public Vector2 getPosition() {
        return position;
    }

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        position = new Vector2(0.0f, 0.0f);
        speed = 12.0f;
        active = false;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void destroy() {
        active = false;
    }

    public void update() {
        position.x += speed;
        if (position.x < -20) {
            position.x = 1280 + (float)Math.random() * 300;
            position.y = (float)Math.random() * 720;
            }
    }
}
