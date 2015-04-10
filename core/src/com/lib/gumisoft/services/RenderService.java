package com.lib.gumisoft.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lib.gumisoft.factories.Factory;

public class RenderService {
    private final Factory _factory;
    private BitmapFont font;
    private BitmapFont debugFont;

    public RenderService(Factory factory) {
        _factory = factory;
        setupFonts();
    }
    public void clearScreen() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    public void showBackground(SpriteBatch batch) {
        batch.draw(_factory.getTextureManager().getBackground(), 0, 0);
    }

    public void print(SpriteBatch batch, String text, float x, float y) {
        font.draw(batch, text, x, y);
    }
    public void printDebug(SpriteBatch batch, String text, float x, float y) {
        debugFont.draw(batch, text, x, y);
    }

    private void setupFonts() {
        font = new BitmapFont();
        font.setColor(Color.GREEN);
        font.setScale(1.1f, 1.1f);
        debugFont = new BitmapFont();
        debugFont.setColor(Color.RED);
        debugFont.setScale(1.0f, 1.0f);
    }
}
