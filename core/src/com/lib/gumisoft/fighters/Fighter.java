package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;
import com.lib.gumisoft.services.IRandomizer;

public abstract class Fighter implements IFighter {

    protected final Factory _factory;
    private final IRandomizer _randomizer;
    protected Vector2 _position;
    protected Texture texture;
    protected int directionX;
    protected int directionY;

    public Fighter(Factory factory, Vector2 position) {
        _factory = factory;
        _position = new Vector2(position.x, position.y);
        _randomizer = _factory.getRandomizer();
        setup();
        setTexture();
    }

    protected abstract void setup();
    protected abstract void setTexture();
    protected abstract void applyMousePosition();

    private void changePosition(){
        _position.x += directionX;
        _position.y += directionY;
        overrideIfScreenBoundariesReached();
    }

    private void overrideIfScreenBoundariesReached() {
        _position.x = Math.min(_position.x, Gdx.graphics.getWidth());
        _position.x = Math.max(_position.x, 0);
        _position.y = Math.min(_position.y, Gdx.graphics.getHeight());
        _position.y = Math.max(_position.y, 0);
    }

    private void rotate() {
//        randomizeRotation();
//        applyMousePosition();
    }

    private void randomizeRotation() {
        directionX = _randomizer.getRandomNumber(-1,1);
        directionY = _randomizer.getRandomNumber(-1,1);
    }


    public abstract void render(Batch batch);

    protected void move() {
        directionY = GameParams.HeroMoveSpeed;
        changePosition();
    }

    @Override
    public boolean collision(IFighter fighter) {
        float distanceX = Math.abs(this.getPosition().x - fighter.getPosition().x);
        float distanceY = Math.abs(this.getPosition(). y- fighter.getPosition().y);
        return ( (distanceX <= GameParams._COLLISION_DISTANCE) && (distanceY <= GameParams._COLLISION_DISTANCE ));
    }

    @Override
    public Vector2 getPosition() {
        return this._position;
    }

}
