package flagOfTheUSA;
import java.awt.*;

public class stars {
	/**x and y coordinates of stars as well as radius length*/
	private double radius;
	private double x;
	private double y;
	/**creates a star*/
	public stars(double xc, double yc, double diam){
		this.x = xc;
		this.y = yc;
		this.radius = diam;
	}
		/**draw method*/
		public void draw(Graphics g){
			g.setColor(Color.WHITE);
			/**designate		s 10 points, arrays of x and y coordinates of each*/
			int[] xpoints = new int[10];
			int[] ypoints = new int[10];
			/**radius of center circle*/
			double centerRadius = 0.382*radius;
			for(int i = 0; i < 5; i++){
				/**Coordinates in the central 5 points*/
				double[] innerCoordinates;
				/**Coordinates in the outer 5 points*/
				double[] outerCoordinates;
				/**finds inner points*/
				innerCoordinates = findCirclePoint(236+72*i, centerRadius);
				xpoints[i*2] = (int)(innerCoordinates)[0];
				ypoints[i*2] = (int)(innerCoordinates)[1];
				/**find outer points*/
				outerCoordinates = findCirclePoint(270+72*i, radius);
				xpoints[i*2+1] = (int)outerCoordinates[0];
				ypoints[i*2+1] = (int)outerCoordinates[1];
			}
			/**puts all points together*/
			g.fillPolygon(xpoints, ypoints, 10);
		}
		/**finds point on inner circle based on sin and cos of x and y points*/
		private double[] findCirclePoint(int deg, double radius){
			double xPoint = Math.cos(Math.toRadians(deg))*radius + this.x;
			double yPoint = Math.sin(Math.toRadians(deg))*radius + this.y;
			double[] coord = {xPoint, yPoint};
			return coord;
		}
		/**
		 * scales star
		 * @param updatedHeight: New height of star as defined by flag height
		 * @param updatedWidth: New width of star as defined by flag height
		 * @param height: Existing height of star
		 * @param width: Existing width of star
		 */
		public void scale(int updatedHeight, int updatedWidth, int height, int width){
			double hRatio = (double)updatedHeight/(double)height;
			double wRatio = (double)updatedWidth/(double)width;
			this.x *= wRatio;
			this.y *= hRatio;
			this.radius *= (wRatio + hRatio)/2;
		}
		
}
