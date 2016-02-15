import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean vis;
	protected Image image;
	
	public Sprite(int x, int y){
		this.x = x;
		this.y = y;
		vis = true;
	}
	
	protected void loadImage(String imageLocation){
		ImageIcon ii = new ImageIcon(imageLocation);
		image = ii.getImage();
	}
	
	protected void getImageDimensions(){
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image getImage(){
		return image;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isVisible(){
		return vis;
	}
	
	public void setVisible(Boolean visible){
		vis = visible;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	

}
