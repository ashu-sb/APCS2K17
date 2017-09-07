package flagOfTheUSA;
import java.awt.*;
import javax.swing.*;

public class Flag extends JPanel{
	/**Flag dimension variables*/
	public int height;
	public int width;
	/**Flag color variables*/
	public Color oldGloryBlue = new Color (0, 82, 165);
	public Color oldGloryRed = new Color(224, 22, 43);
	public stripes[] stripeArray = new stripes[13];
	public stars[] starArray = new stars[50];
	public stripes unionBox;
	/**
	 * Full constructor of flag
	 * @param height: height of flag
	 * @param width: width of flag
	 */
	public Flag(int height, int width){
		int[]dimensions = findFlagDimensions(width, height);
		this.height = dimensions[0];
		this.width = dimensions[1];
		initialize();
	}
	/**Finds dimensions of flag based on size of window given as arguments*/
	private int[] findFlagDimensions(int width, int height) {
	int flagWidth;
	int flagHeight;
	if ((double)width/1.9 < height){
		flagHeight = (int)(width/1.9);
		flagWidth = width;
	}
	else if ((double)width/1.9 > height){
		flagWidth = (int)(height * 1.9);
		flagHeight = height;
	}else{
		flagWidth = width;
		flagHeight = height;
	}
	return new int[] {flagHeight, flagWidth};
	}
	/**Initializes flag, stripes and stars*/
	public void initialize(){
		setBackground(Color.DARK_GRAY);
		setSize(width, height);
		repaint();
		createStripes();
		createStars();
	}
	/**
	 * Method to create stripes and union box
	 * Creates stripe width based on height of flag
	 * Determines if the number of the stripe is odd or even and then determines its color appropriately
	 * Sizes seven stripes to be placed to the right of the union box and then sizes six more stripes to be placed below to take up the full width of the flag
	 * Places all stripes in stripe array
	 */
	public void createStripes(){
		unionBox = new stripes(0, 0, height*0.76, ((7.0/13.0)*height), oldGloryBlue);
		double stripeWidth = 1.0/13.0*height;
		for(int i = 0; i < 7; i++){
		if(i % 2 == 0){
			stripeArray[i] = new stripes(height*0.76, (stripeWidth*i), width-(height*0.76), stripeWidth, oldGloryRed);
		}else{
			stripeArray[i] = new stripes(height*0.76, (stripeWidth*i), width-(height*0.76), stripeWidth, Color.WHITE);
		}
		}
		for(int i = 7; i < 13; i++){
			if(i % 2 == 0){
				stripeArray[i] = new stripes(0, (stripeWidth*i), width, stripeWidth, oldGloryRed);
			}else{
				stripeArray[i] = new stripes(0, (stripeWidth*i), width, stripeWidth, Color.WHITE);
			}
		}
	}
	/**Draws stripes taken from stripe array*/
	public void drawStripes(Graphics g){
		for(int i = 0; i < 13; i++){
			stripeArray[i].draw(g);
		}
	}
	/**Scales stripes based on flag size, reference scale method in stripe file*/
	public void scaleStripes(int height, int width, int height2, int width2){
		for(int i = 0; i < 13; i++){
			stripeArray[i].scale(height, width, height2, width2);
		}
	}
	/**
	 * Creates stars based on dimensions listed in flag dimension doc and constructs them based on appropriate dimensions
	 * x and y determined by where the star should be placed on the graph
	 * Nested loops calculate x and y
	 * Places stars in star array
	 */
	public void createStars(){
		int i = 0;
		for (double y = height*0.054; y < height*0.54; y += height*0.108){
			for(double x = height*0.063; x < height*0.756; x += height*0.126){
				starArray[i] = new stars(x, y, height*0.0308);
				i++;
			}
		}
		for (double y = height*0.108; y < height*0.54; y += height*0.108){
			for(double x = height*0.126; x < height*0.756; x += height*0.126){
				starArray[i] = new stars(x, y, height*0.0308);
				i++;
			}
		}
	}
	/**draws stars taken from star array*/
	public void drawStars(Graphics g){
		for(int i = 0; i < 50; i++){
			starArray[i].draw(g);
		}
	}
	/**scales stars from flag size (reference scale method within star file*/
	public void scaleStars(int height, int width, int height2, int width2){
		for(int i = 0; i < 50; i++){
			starArray[i].scale(height, width, height2, width2);
		}
	}
	/**
	 * paintComponent method creates flag in graphics
	 * Takes size of window
	 * Creates rectangle of a set color (will be flag)
	 * Creates stripes, union and stars in that order
	 * finds dimensions (width and height) within a dimension array
	 * Scales all parts of flag and resets height and width of flag
	 */
	public void paintComponent(Graphics g){
		Dimension x = this.getSize();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, x.width + 100, x.height + 100);
		drawStripes(g);
		unionBox.draw(g);
		drawStars(g);	
		int [] flagDimensions = findFlagDimensions(x.width, x.height);
		int flagHeight = flagDimensions[0];
		int flagWidth = flagDimensions[1];
		scaleStripes(flagHeight, flagWidth, height, width);
		unionBox.scale(flagHeight, flagWidth, height, width);
		scaleStars(flagHeight, flagWidth, height, width);
		this.height = flagHeight;
		this.width = flagWidth;
	}

}
