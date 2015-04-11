package com.lib.gumisoft.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lib.gumisoft.heroMain;
import com.lib.gumisoft.params.GameParams;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameParams.ScreenWidth;
		config.height = GameParams.ScreenHeight;
		new LwjglApplication(new heroMain(), config);
	}
}
