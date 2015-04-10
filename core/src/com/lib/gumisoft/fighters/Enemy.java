package com.lib.gumisoft.fighters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;

public class Enemy extends Fighter {
    public Enemy(Factory factory, Vector2 position) {
        super(factory, position);
    }

    @Override
    protected void setup() {
    }

    @Override
    protected void setTexture() {
    }

    @Override
    protected void applyMousePosition() {}

    @Override
    public void render(Batch batch) {
        move();
        batch.draw(texture, _position.x, _position.y);
    }


}
