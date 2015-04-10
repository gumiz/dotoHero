package com.lib.gumisoft.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lib.gumisoft.factories.Factory;

import java.util.concurrent.TimeUnit;

public class LegendDisplayService {
    private final Factory _factory;
    private long startTime;

    public LegendDisplayService(Factory factory) {
        _factory = factory;
    }

    public void renderLegend(SpriteBatch batch, int ninjagos, int enemies) {
    }
    public void renderDebug(SpriteBatch batch) {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        _factory.getRenderFactory().printDebug(batch, "Mouse pos: " + String.valueOf(Gdx.input.getX()) + "," + String.valueOf(Gdx.input.getY()), 5, 480);
        _factory.getRenderFactory().printDebug(batch, "Real pos: " + String.valueOf(mouseX) + "," + String.valueOf(mouseY), 5, 465);
    }

    public void restartTimer() {
        startTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}
