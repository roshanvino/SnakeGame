package com.vino.snake.original;

import java.awt.*;

/**
 * An abstract class representing object in the Snake game.
 *  provides common properties and methods for snake.
 */
public abstract class SnakeObject {

    /**
     * The x-coordinate of the snake.
     */
    int x;

    /**
     * The y-coordinate of the snake.
     */
    int y;

    /**
     * The image representing the snake
     */
    Image i;

    /**
     * The width of the snake
     */
    int snakeWidth;

    /**
     * The height of the snake
     */
    int snakeHeight;

    /**
     * indicates whether the snake object is alive.
     */
    public boolean alive;

    /**
     * Draws the object on the specified Graphics context.
     *
     * @param g
     */
    public abstract void draw(Graphics g);

    /**
     *
     * @return A Rectangle object
     */
    public Rectangle getRectangle() {
        return new Rectangle(x, y, snakeWidth, snakeHeight);
    }
}
