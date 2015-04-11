package com.lib.gumisoft.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class TextureManager {
    private final Factory _factory;
    private final Array<Texture> trees;
    private final Texture background;
    private final Texture idleUrsaFrames;
    private final Texture backgroundTopLayer;
    private final Texture idleBallFrames;
    private final Texture ballFrames;
    private Texture ursaFrames;

    public TextureManager(Factory factory) {
        _factory = factory;
        trees = new Array<Texture>();
        background = new Texture("img/background.png");
        backgroundTopLayer = new Texture("img/backgroundTopLayer.png");
        ursaFrames = new Texture("img/ursa.png");
        idleUrsaFrames = new Texture("img/idleUrsa.png");
        ballFrames = new Texture("img/ball.png");
        idleBallFrames = new Texture("img/idleBall.png");
    }

    public Texture getBackground() {
        return background;
    }
    public Texture getBackgroundTopLayer() {
        return backgroundTopLayer;
    }
    public Array<Texture> getTreeTextures() {
        return trees;
    }

    public Texture getUrsaFrames() {
        return ursaFrames;
    }
    public Texture getIdleUrsaFrames() {
        return idleUrsaFrames;
    }
    public Texture getBallFrames() {
        return ballFrames;
    }
    public Texture getIdleBallFrames() {
        return idleBallFrames;
    }
}
