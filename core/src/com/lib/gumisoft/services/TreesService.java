package com.lib.gumisoft.services;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.entities.Tree;
import com.lib.gumisoft.factories.Factory;

public class TreesService {
    private final Factory _factory;
    private Array<Tree> trees;

    public TreesService(Factory factory) {
        _factory = factory;
        trees = new Array<Tree>();
    }

    public void createTrees() {
        trees.clear();
        for (int i = 0; i < 30; i++) {
            Tree tree = _factory.getTree();
            trees.add(tree);
        }
    }

    public void renderTrees(SpriteBatch batch) {
        for (Tree tree : trees)
            tree.render(batch);
    }

}
