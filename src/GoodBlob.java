
import java.awt.event.KeyEvent;


public class GoodBlob extends Sprite {

	private int dx;
	private int dy;
	private double currentScale;
	private double newScale;
	private int theta1, theta2;
	
	private final int SCALING_FACTOR = 3;
	private final int SPEED = 3;

	public GoodBlob(int x, int y) {
		super(x, y);
		initGoodBlob();
	}

	private void initGoodBlob() {
		loadImage("src/Assets/blob_1.png");
		theta1 = 0;
		newScale = 1;

		getImageDimensions();
	}

	public void move() {
		x += dx;
		y += dy;
		theta1 = theta1 + (theta2 - theta1) / 2;
		currentScale += (newScale - currentScale)/2;

	}

	public int getOrientation() {
		return theta1;
	}

	public double getScale() {
		return currentScale;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {

			newScale = SCALING_FACTOR;
			

		}

		if (key == KeyEvent.VK_LEFT) {
			dx = -SPEED;
			if (theta1 >= 179 && theta1 <= 270) {
				theta2 = 270;
			} else {
				theta2 = -90;
			}

		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = SPEED;
			theta2 = 90;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -SPEED;
			if (theta1 > 268) {
				theta1 = -90;
			}
			theta2 = 180;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = SPEED;
			if (theta1 <= -89) {
				theta1 = 270;
			}
			theta2 = 180;
		}

	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			newScale = 1;
		}

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}

	}

}
