package com.lib.gumisoft.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class TextureManager {
    private final Factory _factory;
    private final Array<Texture> trees;
    private final Texture background;
    private Texture ursaFrames;

    public TextureManager(Factory factory) {
        _factory = factory;
        trees = new Array<Texture>();
        background = new Texture("img/background01.png");
        ursaFrames = new Texture("img/ursaUp.png");
    }

    public Texture getBackground() {
        return background;
    }
    public Array<Texture> getTreeTextures() {
        return trees;
    }

    public Texture getUrsaFrames() {
        return ursaFrames;
    }
}
