package flagOfTheUSA;

import javax.swing.JFrame;

public class Main {
	/**Main method creates JFrame, flag, sets size appropriately, sets app to exit when closing to avoid crashing*/
	public static void main(String[] args) {
		JFrame a = new JFrame();
		Flag m = new Flag(500, 950);
		a.add(m);
		a.setSize(950,575);
		a.setVisible(true);
		a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
 }
}
