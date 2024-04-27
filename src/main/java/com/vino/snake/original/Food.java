package com.vino.snake.original;

import java.awt.*;
import java.util.Random;

public class Food extends SnakeObject
{
	/**
	 * sets the snake height and width
	 * and sets snake to be alive so game keeps running
	 */
	public Food()	{
		this.alive = true;

		this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.snakeWidth = i.getWidth(null);
		this.snakeHeight = i.getHeight(null);

		this.x = (int) (Math.random() * (870 - snakeWidth + 10));
		this.y = (int) (Math.random() * (560 - snakeHeight - 40));
	}

	/**
	 * sets what to do when snake comes in contact with food
	 * + 10 points and + 1 length
	 * @param mySnake
	 */
	public void eaten(MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && alive && mySnake.alive)		{
			this.alive = false;
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 10; //snake score increase changed from 531 to 10
		}
	}

	/**
	 * draws image of snake
	 * @param g
	 */
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(i, x, y, null);
	}
}
