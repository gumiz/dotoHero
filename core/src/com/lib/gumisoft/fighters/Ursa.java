package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
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

    public Ursa(Factory factory, Vector2 position) {
        super(factory, position);
    }

    @Override
    protected void setup() {
        Texture sheet = _factory.getTextureManager().getUrsaFrames();
        animated = TextureRegion.split(sheet, sheet.getWidth()/GameParams.NumberOfHorizontalFrames, sheet.getHeight()/GameParams.NumberOfVerticalFrames);
        int allFrames = GameParams.NumberOfHorizontalFrames * GameParams.NumberOfVerticalFrames;
        walkFrames = new TextureRegion[allFrames];
        int index = 0;
        for (int x=0; x<GameParams.NumberOfVerticalFrames; x++)
            for (int y=0; y<GameParams.NumberOfHorizontalFrames; y++)
            walkFrames[index++] = animated[x][y];
        walkAnimation = new Animation(GameParams.HeroAnimationSpeed, walkFrames);
        animationTime = 0f;
    }

    @Override
    protected void setTexture() {
    }

    @Override
    public void render(Batch batch) {
        move();
        drawHero(batch);
    }

    private void drawHero(Batch batch) {
        animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime, true);
        batch.draw(currentFrame, heroPosition.x, heroPosition.y, GameParams.HeroWidth / 2, GameParams.HeroHeight / 2, GameParams.HeroWidth, GameParams.HeroHeight, 1, 1, heroDirection.angle()-90f);
    }
}
