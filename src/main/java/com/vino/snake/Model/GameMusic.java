package com.vino.snake.Model;

/**
 * The GameMusic manages the background music for the Snake game.
 * provides getters and setters for the current Music file.
 */
public class GameMusic {
    private static String musicNum = "frogger.mp3";

    public static String getMusicNum() {
        return musicNum;
    }

    public static void setMusicNum(String newMusicNum) {
        musicNum = newMusicNum;
    }
}