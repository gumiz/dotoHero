package com.lib.gumisoft.services;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public class BallFighterService extends FightersService {

    public BallFighterService(Factory factory) {
        super(factory);
    }

    protected void createNewHero() {
        _newHero = _factory.createBall(GameParams.HeroSpawnPosition);
    }

    protected void cloneNewHero() {
    }

}
