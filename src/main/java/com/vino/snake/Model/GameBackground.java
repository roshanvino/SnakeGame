package com.vino.snake.Model;

/**
 * The GameBackground manages the background for the Snake game.
 * provides getters and setters for the current background image.
 */
public class GameBackground {
    private static String backgroundNum = "UI-background";

    public static String getBackgroundNum() {
        return backgroundNum;
    }

    public static void setBackgroundNum(String newBackgroundNum) {
        backgroundNum = newBackgroundNum;
    }
}