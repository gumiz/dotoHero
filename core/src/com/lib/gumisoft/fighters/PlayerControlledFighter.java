package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;

public abstract class PlayerControlledFighter extends Fighter {

    public PlayerControlledFighter(Factory factory, Vector2 position) {
        super(factory, position);
    }

    @Override
    protected void applyMousePosition() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        if (mouseX > _position.x)
            directionX++;
        else
            directionX--;
        if (mouseY > _position.y)
            directionY++;
        else
            directionY--;
    }
}
