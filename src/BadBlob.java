import java.util.Random;

public class BadBlob extends Sprite {

	private int dx;
	private int dy;
	private Random randX;
	private Random randY;

	private final int SPEED = 3;
	private final int BOARD_X = 668;
	private final int BOARD_Y = 690;

	public BadBlob(int x, int y) {
		super(x, y);
		initBadBlob();
	}

	private void initBadBlob() {
		loadImage("src/Assets/badblob_1.png");
		getImageDimensions();
		randX = new Random();
		randY = new Random();
		dx = 0;
		dy = 1;
	}

	private void generateRandom() {

		dx = randX.nextInt(3) - 1;
		dy = randY.nextInt(3) - 1;

	}

	public void move() {

		if (y > 600) {
			generateRandom();
		} else if (y < 0) {
			generateRandom();
		} else if (x > 600) {
			generateRandom();
		} else if (x < 0) {
			generateRandom();
		}

		x += dx;
		y += dy;

	}

}
