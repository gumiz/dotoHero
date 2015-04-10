package com.lib.gumisoft.services;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public class UrsaFighterService extends FightersService {

    public UrsaFighterService(Factory factory) {
        super(factory);
    }

    protected void createNewHero() {
        _newHero = _factory.createHeroUrsa(GameParams.HeroSpawnPosition);
    }

    protected void cloneNewHero() {
        Vector2 pos = _heroes.get(0).getPosition();
        _heroes.add(_factory.createHeroUrsa(pos));
    }

}
