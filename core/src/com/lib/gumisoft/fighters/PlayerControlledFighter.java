package com.lib.gumisoft.fighters;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;

public abstract class PlayerControlledFighter extends Fighter {

    public PlayerControlledFighter(Factory factory, Vector2 position) {
        super(factory, position);
    }

}
