package com.mygdx.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BackgroundSound {

    public Music music;
    public BackgroundSound(){

        music = Gdx.audio.newMusic(Gdx.files.internal("assets/sound/bgsound2.ogg"));
        music.setLooping(true);
        music.play();
    }

}