package com.lib.gumisoft.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;

public class Tree {
    private final Factory _factory;
    private int randomModelIndex;
    private Texture texture;
    private Vector2 position;

    public Tree(Factory factory) {
        _factory = factory;
        getRandomModelIndex();
        this.texture = _factory.getTextureManager().getTreeTextures().get(randomModelIndex);
        int x = _factory.getRandomizer().getRandomNumber(Gdx.graphics.getWidth());
        int y = _factory.getRandomizer().getRandomNumber(Gdx.graphics.getHeight());
        this.position = new Vector2(x,y);
    }

    private void getRandomModelIndex() {
        int numberOfModels = _factory.getTextureManager().getTreeTextures().size;
        randomModelIndex = _factory.getRandomizer().getRandomNumber(numberOfModels-1);
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.texture, this.position.x, this.position.y);
    }
}
