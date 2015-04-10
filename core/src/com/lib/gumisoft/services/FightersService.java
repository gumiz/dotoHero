package com.lib.gumisoft.services;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;
import com.lib.gumisoft.fighters.PlayerControlledFighter;
import com.lib.gumisoft.params.GameParams;

public abstract class FightersService {
    protected final Factory _factory;
    protected PlayerControlledFighter _newHero;
    protected Array<IFighter> _heroes;
    private Array<IFighter> _enemies;

    public FightersService(Factory factory) {
        _factory = factory;
    }

    public void renderFighters(SpriteBatch batch, Array<IFighter> fighters) {
        for (IFighter fighter : fighters)
            fighter.render(batch);
    }

    public void prepareFighters(Array<IFighter> heroes, Array<IFighter> enemies) {
        _heroes = heroes;
        _enemies = enemies;
        destroyFighters();
        createNewHeroes();
    }

    public void cloneHeroes() {
        if (isTimeToCloneHero()) {
            cloneNewHero();
        }
    }

    protected abstract void cloneNewHero();

    private boolean isTimeToCloneHero() {
        return (_factory.getRandomizer().rollDice(GameParams.HeroesSpawnTimeDelay) && _heroes.size < _enemies.size);
    }

    private void createNewEnemies() {
        for (int i = 0; i < GameParams.NumberOfEnemies; i++) {
            IFighter enemy = _factory.createNewEnemy(GameParams.EnemySpawnPosition);
            _enemies.add(enemy);
        }
    }

    protected void createNewHeroes() {
        for (int i = 0; i < GameParams.NumberOfHeroes; i++) {
            createNewHero();
            _heroes.add(_newHero);
        }
    }

    protected abstract void createNewHero();

    private void destroyFighters() {
        _heroes.clear();
        _enemies.clear();
    }

}
