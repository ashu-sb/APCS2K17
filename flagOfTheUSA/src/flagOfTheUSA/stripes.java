package flagOfTheUSA;
import java.awt.*;

public class stripes {
	private Color color;
	public double x;
	public double y;
	public double width;
	public double height;
	/**
	 * Constructor of stripe
	 * @param x: x coordinate
	 * @param y: y coordinate
	 * @param width: width of stripe
	 * @param height: height of stripe
	 * @param color: color of stripe
	 */
	public stripes(double x, double y, double width, double height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	/**draw method sets stripe to a rectangle and constructs with x, y, width, height and sets color*/
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	/**
	 * Method that scales flag
	 * @param updatedHeight: New height of stripe based on increased/decreased window size
	 * @param updatedWidth: New width of stripe based in increased/decreased window size
	 * @param height: Existing height of stripe
	 * @param width: Existing width of stripe
	 */
	public void scale(int updatedHeight, int updatedWidth, int height, int width){
		double sclFactor = (double)(updatedHeight + updatedWidth)/(double)(height + width);
		this.x *= sclFactor;
		this.y *= sclFactor;
		this.height *= sclFactor;
		this.width *= sclFactor;
	}
}
