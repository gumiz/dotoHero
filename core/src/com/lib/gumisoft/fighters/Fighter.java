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
    }

    protected abstract void setup();
    protected abstract void setTexture();

    private void OverrideIfScreenBoundariesReached() {
        heroPosition.x = Math.min(heroPosition.x, Gdx.graphics.getWidth());
        heroPosition.x = Math.max(heroPosition.x, 0);
        heroPosition.y = Math.min(heroPosition.y, Gdx.graphics.getHeight());
        heroPosition.y = Math.max(heroPosition.y, 0);
    }

    public abstract void render(Batch batch);

    protected void move() {
        GetCurrentMousePosition();
        GetDirection();
        SetDirection();
        OverrideIfScreenBoundariesReached();
    }

    private void SetDirection() {
        heroPosition.add(heroDirection.scl(GameParams.HeroVelocity * Gdx.graphics.getDeltaTime()));
    }

    private void GetDirection() {
        heroCenterPosition = new Vector2(heroPosition.x + GameParams.HeroWidth/2, heroPosition.y + GameParams.HeroHeight/2);
        float distance = heroCenterPosition.dst(mousePosition);
        heroDirection = mousePosition.sub(heroCenterPosition).nor();
        if (distance < 10)
            heroDirection = new Vector2(0,0);
    }

    private void GetCurrentMousePosition() {
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
