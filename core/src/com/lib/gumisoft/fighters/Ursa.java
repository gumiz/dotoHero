package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public class Ursa extends PlayerControlledFighter {
    private TextureRegion[][] animated;
    private TextureRegion[] walkFrames;
    private Animation walkAnimation;
    private float animationTime;
    private TextureRegion currentFrame;
    private float frameAngle;
    private int soundDelay;
    private Animation idleAnimation;
    private TextureRegion currentIdleFrame;

    public Ursa(Factory factory, Vector2 position) {
        super(factory, position);
    }

    @Override
    protected void setup() {
        walkAnimation = GetUrsaGraphics(_factory.getTextureManager().getUrsaFrames());
        idleAnimation = GetUrsaGraphics(_factory.getTextureManager().getIdleUrsaFrames());
        animationTime = 0f;
        currentFrame = walkAnimation.getKeyFrame(animationTime, true);
        frameAngle = 0f;
    }

    private Animation GetUrsaGraphics(Texture  sheet) {
        animated = TextureRegion.split(sheet, sheet.getWidth() / GameParams.NumberOfHorizontalFrames, sheet.getHeight() / GameParams.NumberOfVerticalFrames);
        int allFrames = GameParams.NumberOfHorizontalFrames * GameParams.NumberOfVerticalFrames;
        walkFrames = new TextureRegion[allFrames];
        int index = 0;
        for (int x=0; x<GameParams.NumberOfVerticalFrames; x++)
            for (int y=0; y<GameParams.NumberOfHorizontalFrames; y++)
            walkFrames[index++] = animated[x][y];
        return new Animation(GameParams.HeroAnimationSpeed, walkFrames);
    }

    @Override
    protected void setTexture() {
    }

    @Override
    public void render(Batch batch) {
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
        {
            GetCurrentMousePosition();
        }
        move();
        drawHero(batch);
    }

    private void drawHero(Batch batch) {
        animationTime += Gdx.graphics.getDeltaTime();
        if (movementDetected()) {
            currentFrame = walkAnimation.getKeyFrame(animationTime, true);
            frameAngle = heroDirection.angle()-90f;
            playFootsteps();
            batch.draw(currentFrame, heroPosition.x, heroPosition.y, GameParams.HeroWidth / 2, GameParams.HeroHeight / 2, GameParams.HeroWidth, GameParams.HeroHeight, 1, 1, frameAngle);
        } else {
            currentIdleFrame = idleAnimation.getKeyFrame(animationTime, true);
            batch.draw(currentIdleFrame, heroPosition.x, heroPosition.y, GameParams.HeroWidth / 2, GameParams.HeroHeight / 2, GameParams.HeroWidth, GameParams.HeroHeight, 1, 1, frameAngle);
        }
    }

    private void playFootsteps() {
        soundDelay++;
        if (soundDelay==25) {
            _factory.getSoundManager().playRandomSword();
            soundDelay=0;
        }
    }

    private boolean movementDetected() {
        return !heroDirection.isZero();
    }
}
