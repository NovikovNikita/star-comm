package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import org.lwjgl.Sys;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "\\xD0\\x9D\\xD0\\xB8\\xD0\\xBA\\xD0\\xB8\\xD1\\x82\\xD0\\xB0");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
