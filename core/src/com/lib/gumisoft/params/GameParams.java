package com.lib.gumisoft.params;

import com.badlogic.gdx.math.Vector2;

public class GameParams {
    public static float HeroWidth = 130;
    public static float HeroHeight = 130;
    public static int NumberOfHorizontalFrames = 6;
    public static int NumberOfVerticalFrames = 4;

    public static final int NumberOfHeroes = 1;
    public static final int NumberOfEnemies = 0;
    public static final int HeroesSpawnTimeDelay = 10;
    public static final Vector2 HeroSpawnPosition = new Vector2(250, 0);
    public static final Vector2 EnemySpawnPosition = new Vector2(400, 300);
    public static final int _COLLISION_DISTANCE = 5;
    public static float HeroVelocity = 80;
    public static float HeroAnimationSpeed = 0.04f;
}
