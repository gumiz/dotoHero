package com.lib.gumisoft.services;

import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.params.GameParams;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;

public class CollisionResolver {
    private final Factory _factory;
    private Array<IFighter> _enemies;
    private Array<IFighter> _heroes;

    public CollisionResolver(Factory factory) {
        _factory = factory;
    }

    public void resolveCollisions(Array<IFighter> heroes, Array<IFighter> enemies) {
        _heroes = heroes;
        _enemies = enemies;
        resolveCollision();
    }

    private void resolveCollision() {
        for (IFighter hero : _heroes) {
            for (IFighter enemy : _enemies)
                if (hero.collision(enemy)) {
                    dropRandomFighter(hero, enemy);
                    _factory.getSoundManager().playRandomSword();
                }
        }
    }

    private void dropRandomFighter(IFighter hero, IFighter enemy) {
        if (_factory.getRandomizer().rollDice(2))
            _heroes.removeValue(hero, true);
        else
            _enemies.removeValue(enemy, true);
    }

}
