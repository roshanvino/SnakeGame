package com.vino.snake.original;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Represents the main frame of the Snake game
 * Extends JPanel and implements KeyListener and MouseListener interfaces.
 */
public class MyFrame extends JPanel implements KeyListener, MouseListener {

	/**
	 * JFrame used for the game
	 */
	public JFrame jFrame = new JFrame();

	/**
	 * constructs a new MyFrame object
	 * configures JFrame, sets the icon image, adds listeners
	 */
	public MyFrame() {
		jFrame.setIconImage(ImageUtil.images.get("snake-logo.png"));
		jFrame.addMouseListener(this);
	}

	/**
	 * Loads the main game frame.
	 * Sets the size, title, location, and window listener
	 * Starts a new thread to continuously repaint the frame
	 */
	public void loadFrame() {
		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("Snakee Yipee");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		new MyThread().start();
	}

	/**
	 * Continuously repaints the frame
	 */
	class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			while (true) {
				repaint();
				try {
					sleep(30);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO: Implement if needed
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO: Implement if needed
	}
}