package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;
import com.lib.gumisoft.services.FightersService;

public class heroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private Factory factory;
	private final Array<IFighter> heroes = new Array<IFighter>();
	private final Array<IFighter> enemies = new Array<IFighter>();
	private FightersService fightersService;

	@Override
	public void create () {
		factory = new Factory();
		batch = new SpriteBatch();
		fightersService = factory.getUrsaFighterService();
		fightersService.prepareFighters(heroes, enemies);
	}

	@Override
	public void render () {
		batch.begin();
		handleGameFrame();
		controlUserInput();
		batch.end();
	}

	private void handleGameFrame() {
		factory.getRenderFactory().clearScreen();
		factory.getRenderFactory().renderBackground(batch);
		fightersService.renderFighters(batch, heroes);
		factory.getRenderFactory().renderBackgroundTopLayer(batch);
	}

	public void controlUserInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))  {
			System.exit(0);
		}
	}
}
