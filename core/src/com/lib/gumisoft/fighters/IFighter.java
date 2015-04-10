package com.lib.gumisoft.fighters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public interface IFighter {
    void render(Batch batch);
    boolean collision(IFighter fighter);
    Vector2 getPosition ();
}
