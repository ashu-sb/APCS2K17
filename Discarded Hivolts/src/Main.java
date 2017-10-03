import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame b = new JFrame();
		HiVolts h = new HiVolts();
		b.add(h);
		b.setSize(2500, 1500);
		b.setVisible(true);
		b.setDefaultCloseOperation(b.EXIT_ON_CLOSE);
	}

}
