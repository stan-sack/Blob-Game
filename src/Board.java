import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private Image gameBoardImage;
	private final int DELAY = 10;
	
	private GoodBlob goodBlob;
	private int goodBlobWidth;
	private int goodBlobHeight;
	private int goodBlobX;
	private int goodBlobY;
	
	private BadBlob badBlob;
	private int badBlobWidth;
	private int badBlobHeight;
	private int badBlobX;
	private int badBlobY;
	
	
	private final int GOOD_BLOB_X0 = 40;
	private final int GOOD_BLOB_Y0 = 60;
	private final int BAD_BLOB_X0 = 100;
	private final int BAD_BLOB_Y0 = 100;


	public Board() {
		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		ImageIcon ii = new ImageIcon("src/Assets/floor_1.png");
		gameBoardImage = ii.getImage();

		goodBlob = new GoodBlob(GOOD_BLOB_X0, GOOD_BLOB_Y0);
		goodBlobWidth = goodBlob.getWidth();
		goodBlobHeight = goodBlob.getHeight();
		
		badBlob = new BadBlob(BAD_BLOB_X0, BAD_BLOB_Y0);
		badBlobWidth = badBlob.getWidth();
		badBlobHeight = badBlob.getHeight();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(gameBoardImage, 0, 0, this);
		g2d.drawImage(badBlob.getImage(), badBlob.getX(), badBlob.getY(), this);
		g2d.rotate(Math.toRadians(goodBlob.getOrientation()), goodBlob.getX() + goodBlobWidth / 2,
				goodBlob.getY() + goodBlobHeight / 2);
		g2d.scale(goodBlob.getScale(), goodBlob.getScale());

		if (goodBlob.getScale() > 1) {
			goodBlobX = (int) (goodBlob.getX() / goodBlob.getScale() - .5 * goodBlobWidth + .5*goodBlobWidth/goodBlob.getScale());
			goodBlobY = (int) (goodBlob.getY() / goodBlob.getScale() - .5 * goodBlobHeight + .5*goodBlobHeight/goodBlob.getScale());
		} else {
			goodBlobX = goodBlob.getX();
			goodBlobY = goodBlob.getY();
		}

		g2d.drawImage(goodBlob.getImage(), goodBlobX, goodBlobY, this);
		g2d.rotate(Math.toRadians(-goodBlob.getOrientation()), goodBlob.getX() + goodBlobWidth / 2,
				goodBlob.getY() + goodBlobHeight / 2);
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		updateGoodBlob();
		updateBadBlob();
		repaint();
	}

	private void updateGoodBlob() {
		goodBlob.move();
		goodBlob.getScale();
	}
	
	private void updateBadBlob() {
		badBlob.move();
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			goodBlob.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			goodBlob.keyPressed(e);
		}
	}
}
