package com.lib.gumisoft.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;

public class SoundService {
    private Factory _factory;

    private static Array<Sound> swords = new Array<Sound>();

    public SoundService(Factory factory) {
        _factory = factory;
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps01.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps02.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps03.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps04.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps05.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps06.mp3")));
        swords.add(Gdx.audio.newSound(Gdx.files.internal("audio/footsteps07.mp3")));
    }

    public void playRandomSword() {
        swords.get(_factory.getRandomizer().getRandomNumber(6)).play(0.1f);
    }
}
