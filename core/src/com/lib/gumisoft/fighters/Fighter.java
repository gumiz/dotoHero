package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public abstract class Fighter implements IFighter {

    protected final Factory _factory;
    protected Vector2 heroPosition;
    protected Vector2 heroDirection;
    protected Texture texture;
    private Vector2 mousePosition;
    private Vector2 heroCenterPosition;

    public Fighter(Factory factory, Vector2 position) {
        _factory = factory;
        heroPosition = new Vector2(position.x, position.y);
        setup();
        setTexture();
        ResetMousePosition();
    }

    protected void ResetMousePosition() {
        GetHeroCenterPosition();
        mousePosition = heroCenterPosition;
    }

    protected abstract void setup();
    protected abstract void setTexture();

    public abstract void render(Batch batch);

    protected void move() {
        GetDirection();
        SetDirection();
    }

    private void SetDirection() {
        heroPosition.add(heroDirection.scl(GameParams.HeroVelocity * Gdx.graphics.getDeltaTime()));
    }

    private void GetDirection() {
        GetHeroCenterPosition();
        Vector2 destination = mousePosition.cpy();
        heroDirection = destination.sub(heroCenterPosition).nor();
        RotationOverflowProtection();
        ScreenBoundariesProtection();
    }

    private void GetHeroCenterPosition() {
        heroCenterPosition = new Vector2(heroPosition.x + GameParams.HeroWidth/2, heroPosition.y + GameParams.HeroHeight/2);
    }

    private void RotationOverflowProtection() {
        float distance = heroCenterPosition.dst(mousePosition);
        if (distance < 10)
            heroDirection.setZero();
    }

    private void ScreenBoundariesProtection() {
        heroPosition.x = Math.min(heroPosition.x, Gdx.graphics.getWidth());
        heroPosition.x = Math.max(heroPosition.x, 0);
        heroPosition.y = Math.min(heroPosition.y, Gdx.graphics.getHeight());
        heroPosition.y = Math.max(heroPosition.y, 0);
    }

    protected void GetCurrentMousePosition() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        mousePosition = new Vector2(mouseX, mouseY);
    }

    @Override
    public boolean collision(IFighter fighter) {
        float distanceX = Math.abs(this.getPosition().x - fighter.getPosition().x);
        float distanceY = Math.abs(this.getPosition(). y- fighter.getPosition().y);
        return ( (distanceX <= GameParams._COLLISION_DISTANCE) && (distanceY <= GameParams._COLLISION_DISTANCE ));
    }

    @Override
    public Vector2 getPosition() {
        return this.heroPosition;
    }

}
