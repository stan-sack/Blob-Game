import java.awt.EventQueue;

import javax.swing.JFrame;

public class SpaceCraftExample extends JFrame{
	
	private final int BOARD_X = 668;
	private final int BOARD_Y = 690;
	
	public SpaceCraftExample(){
		initUI();
	}
	
	public void initUI(){
		add(new Board());
		setSize(BOARD_X,BOARD_Y);
		setResizable(false);
		setTitle("Space Craft Example");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				SpaceCraftExample ex = new SpaceCraftExample();
				ex.setVisible(true);
			}
		});

	}

}
