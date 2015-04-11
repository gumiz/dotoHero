package com.lib.gumisoft.params;

import com.badlogic.gdx.math.Vector2;

public class GameParams {
    public static int ScreenWidth = 1200;
    public static int ScreenHeight = 700;
    public static float HeroWidth = 180;
    public static float HeroHeight = 180;
    public static float HeroVelocity = 150;

    public static final Vector2 HeroSpawnPosition = new Vector2(250, 100);
    public static final Vector2 EnemySpawnPosition = new Vector2(400, 300);
    public static int NumberOfHorizontalFrames = 6;
    public static int NumberOfVerticalFrames = 4;
    public static final int NumberOfHeroes = 1;
    public static final int NumberOfEnemies = 0;
    public static final int HeroesSpawnTimeDelay = 10;
    public static final int _COLLISION_DISTANCE = 5;
    public static float HeroAnimationSpeed = 0.035f * 100/HeroVelocity;
    public static int FootstepsFramesDelay = Math.round(25 * 100/HeroVelocity);
}
