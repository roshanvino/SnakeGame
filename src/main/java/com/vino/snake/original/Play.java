package com.vino.snake.original;

import com.vino.snake.Model.GameBackground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *Manages the game logic and player input.
 */
public class Play extends MyFrame {

	/**
	 * Indicates if the game is paused
	 */
	private boolean paused = false;
	/**
	 * initialises the snake
	 */
	public MySnake mySnake = new MySnake(100, 100);

	/**
	 * Food for the snake
	 */
	public Food food = new Food();

	/**
	 * Represents the chosen background
	 */
	public String backgroundNum = GameBackground.getBackgroundNum();
	/**
	 * The background image for the game is set
	 */
	public Image background = ImageUtil.images.get(backgroundNum); // setting background for game

	/**
	 * fail image for the game is set when the snake dies
	 */
	public Image fail = ImageUtil.images.get("game-scene-01");

	/**
	 * resizing image for the game over scene
	 */
	Image image = fail.getScaledInstance(900, 600, Image.SCALE_DEFAULT); // resizing game over screen

	/**
	 * handles is the game is paused by pressing space
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			togglePause();
		} else if (!paused) {
			mySnake.keyPressed(e);
		}
	}

	/**
	 * handles is the mouse clicks on retart button
	 * @param e the event to be processed
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if (!mySnake.alive) {
			handleRestartClick();
		}
	}

	/**
	 * loads the game components : background, snake, food, and game over screen
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);

		if (mySnake.alive && !paused) {
			mySnake.draw(g);
			if (food.alive) {
				food.draw(g);
				food.eaten(mySnake);
			} else {
				food = new Food();
			}
		} else if (!mySnake.alive) {
			g.drawImage(image, 0, 0, null);
			drawRestartButton(g);
		}
		drawScore(g);
	}

	/**
	 * Draws the player's score on the screen
	 * @param g
	 */
	public void drawScore(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
		g.setColor(new Color(255, 0, 0));
		g.drawString("SCORE : " + mySnake.score, 10, 20);
	}

	/**
	 * Draws the restart button on the game over screen.
	 * @param g
	 */
	private void drawRestartButton(Graphics g) {
		int buttonX = getWidth() / 2 - 100;
		int buttonY = getHeight() - 90;
		int buttonWidth = 200;
		int buttonHeight = 60;
		int cornerRadius = 15;

		g.setColor(Color.WHITE);
		g.fillRoundRect(buttonX, buttonY, buttonWidth, buttonHeight, cornerRadius, cornerRadius);

		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString("Restart Game", getWidth() / 2 - 60, getHeight() - 50);
	}

	/**
	 * Handles the restart click by resetting the snake and creating new food
	 */
	private void handleRestartClick() {
		mySnake.reset();
		food = new Food();
	}

	/**
	 * toggles between paused and play state
	 */
	private void togglePause() {
		paused = !paused;
	}

	/**
	 * starts the snake game, creates an instance of play and
	 * starts the background music
	 * @param args
	 */
	public static void main(String[] args) {
		new Play().loadFrame();
		MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");
	}
}