package com.vino.snake.original;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * provides the function of playing music in the game
 * extends - thread in order to play continuous background music
 */
public class MusicPlayer extends Thread {
	private String filename;
	public Player player;
	private boolean paused;

	/**
	 * Constructs a new MusicPlayer with the specified filename for the music file.
	 *
	 * @param filename The path to the music file.
	 */
	public MusicPlayer(String filename) {
		this.filename = filename;
	}

	/**
	 * Initiates the music playback in a separate thread.
	 * this allows the music to loop
	 */
	public void play() {
		new Thread(() -> {
			while (true) { // loop to keep music playing
				try {
					FileInputStream fileInputStream = new FileInputStream(filename);
					BufferedInputStream buffer = new BufferedInputStream(fileInputStream);
					player = new Player(buffer);
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}).start();
	}

	/**
	 * Initiates music playback for specified mp3 file.
	 *
	 * @param filename The path to the music file.
	 */
	public static void getMusicPlay(String filename) {
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}

	/**
	 * Toggles between pausing and resuming the music playback.
	 * If paused and a player instance exists, it is closed.
	 */
	public void togglePause() {
		paused = !paused;
		if (paused && player != null) {
			player.close();
		}
	}


}