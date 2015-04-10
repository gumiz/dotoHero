package com.lib.gumisoft.factories;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.entities.Tree;
import com.lib.gumisoft.fighters.Ursa;
import com.lib.gumisoft.fighters.Enemy;
import com.lib.gumisoft.fighters.PlayerControlledFighter;
import com.lib.gumisoft.services.*;

public class Factory {
    private final RenderService renderFactory;
    private final TextureManager textureManager;
    private final CollisionResolver collisionResolver;
    private final UrsaFighterService ursaFighterService;
    private final TreesService treesService;
    private LegendDisplayService legendDisplayService;
    private Randomizer randomizer;
    private SoundService soundManager;

    public Factory() {
        soundManager = new SoundService(this);
        randomizer = new Randomizer();
        legendDisplayService = new LegendDisplayService(this);
        renderFactory = new RenderService(this);
        textureManager = new TextureManager(this);
        collisionResolver = new CollisionResolver(this);
        ursaFighterService = new UrsaFighterService(this);
        treesService = new TreesService(this);
    }
    public RenderService getRenderFactory() {
        return renderFactory;
    }
    public TextureManager getTextureManager() {
        return textureManager;
    }
    public SoundService getSoundManager() {
        return soundManager;
    }
    public PlayerControlledFighter createHeroUrsa(Vector2 position) {
        return new Ursa(this, position);
    }
    public Enemy createNewEnemy(Vector2 position) {
        return new Enemy(this, position);
    }
    public IRandomizer getRandomizer() {
        return randomizer;
    }
    public LegendDisplayService getLegendDisplayService() {
        return legendDisplayService;
    }
    public Tree getTree() {
        return new Tree(this);
    }
    public CollisionResolver getCollisionResolver() {
        return collisionResolver;
    }
    public FightersService getUrsaFighterService() {
        return ursaFighterService;
    }

    public TreesService getTreesService() {
        return treesService;
    }
}
