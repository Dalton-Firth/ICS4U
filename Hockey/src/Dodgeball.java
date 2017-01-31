import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Dodgeball extends GamePanel implements MouseMotionListener {

	/**
	 * the position at which the last mouse down event happened
	 **/
	static int x = -1;

	static int y = -1;

	int width = 1000;
	int height = 600;

	/**
	 * The number of balls on the screen.
	 */
	final static int numBalls = 1000;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 60;
	/**
	 * An array of balls.
	 */
	static FlashingBall[] ball = new FlashingBall[numBalls];

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1000, 600));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
		
	}

	public Dodgeball() {
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);

		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * 16 - 8);
			ball[i].setYSpeed(Math.random() * 16 - 8);
			ball[i].setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		}

		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		//
			//
			//
			//
			//
			//
			//
			//
			
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}

	}
	
	
	public static void Hitboxes(){
		
	}

	/**
	 * Activate the mouse listener
	 **/
	public void init() {
		addMouseMotionListener(this);
	}

	// THE METHODS BELOW ARE REQUIRED FOR THE MouseMotionListener INTERFACE
	// You must always have these methods in any class that implements
	// MouseListener

	/**
	 * called when mouse is moved in the window
	 * 
	 * @param e
	 *            The mouse event
	 **/
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	/**
	 * called when mouse is dragged in the window
	 * 
	 * @param e
	 *            The mouse event
	 **/
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	private static boolean hasColideddWith() {

		//int radius = (int) Math.sqrt(Math.pow(ball[i].getX(), 2) + Math.pow(ball[i].getY(), 2));
		
		for (int i = 0; i < ball.length; i++) {
			if ((x >= ball[i].getX() && x <= ball[i].getX() + 50)
					&& (y >= ball[i].getY() && y <= ball[i].getY() + 50)) {
				return true;
			}
		}

		return false;
	}

}
