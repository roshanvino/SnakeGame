package com.vino.snake.original;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the snake in the game
 * Extends
 */
public class MySnake extends SnakeObject implements movable
{
    private int speed_XY;
    private int length;
    private int num;
    public int score = 0;

    //snake image facing right
    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");

    //list to store body points of snake
    public static List<Point> bodyPoints = new LinkedList<>();

    //snake head after rotation
    private static BufferedImage newImgSnakeHead;
    boolean up, down, left, right = true;

    public MySnake(int x, int y)
    {
        this.alive = true;
        this.x = x;
        this.y = y;
        this.i = ImageUtil.images.get("snake-body");
        this.snakeWidth = i.getWidth(null);
        this.snakeHeight = i.getHeight(null);

        this.speed_XY = 5;
        this.length = 1;

        this.num = snakeWidth / speed_XY;
        newImgSnakeHead = IMG_SNAKE_HEAD;

    }

    /**
     * gets length of the snake
     * @return
     */
    public int getLength()
    {
        return length;
    }

    /**
     * changes kength of the snake
     * @param length
     */
    public void changeLength(int length)
    {
        this.length = length;
    }

    /**
     * handles key presses to change the snake's direction.
     * @param e this is the key press
     */
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (!down)
                {
                    up = true;
                    down = false;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (!up)
                {
                    up = false;
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case KeyEvent.VK_RIGHT:
                if (!left)
                {
                    up = false;
                    down = false;
                    left = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }

    /**
     * Moves snake based on its direction
     */
    public void move()
    {
        if (up)
        {
            y -= speed_XY;
        } else if (down)
        {
            y += speed_XY;
        } else if (left)
        {
            x -= speed_XY;
        } else if (right)
        {
            x += speed_XY;
        }

    }

    /**
     * Draws the snake on the graphics object.
     *
     * @param g The Graphics object to draw on.
     */
    @Override
    public void draw(Graphics g)
    {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point(x, y));

        if (bodyPoints.size() == (this.length + 1) * num)
        {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y, null);
        drawBody(g);

        move();
    }

    /**
     * Checks if  snake has collided with itself
     */
    public void eatBody()
    {
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    this.alive = false;
                }
            }
        }
    }

    /**
     * Draws the body of the snake.
     *
     * @param g The Graphics object to draw on.
     */
    public void drawBody(Graphics g)
    {
        int length = bodyPoints.size() - 1 - num;

        for (int i = length; i >= num; i -= num)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.i, point.x, point.y, null);
        }
    }

    /**
     * Checks if the snake is out of bounds then sets it as not alive.
     */
    private void outofBounds()
    {
        boolean xOut = (x <= 0 || x >= (870 - snakeWidth));
        boolean yOut = (y <= 0 || y >= (560 - snakeHeight)); // fixing the bounds on the game
        if (xOut || yOut)
        {
            alive = false;
        }
    }

    /**
     * Resets the snake to its initial state.
     */
    public void reset() {
        this.alive = true;
        this.x = 100;
        this.y = 100;
        this.speed_XY = 5;
        this.length = 1;
        this.num = snakeWidth / speed_XY;
        bodyPoints.clear();
        newImgSnakeHead = IMG_SNAKE_HEAD;

        up = false;
        down = false;
        left = false;
        right = true;
    }

}