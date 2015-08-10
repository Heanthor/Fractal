import javax.swing.JFrame;

import grid.Grid;

public class Dragon {
	public static void main(String[] args) {
		new Dragon().init();
	}

	private void init() {
		Grid g = new Grid(4, 200, false);

		//Initial square
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				g.drawRect(i, j, Grid.GREEN);
			}
		}

		JFrame f = new JFrame("Heighway Dragon Fractal");
		f.getContentPane().add(g);
		f.pack();
		f.setVisible(true);

		new Thread(new Runnable() {
			public void run() {
				shift(g, 0);
			}
		});
	}

	private void shift(Grid g, int count) {
		
	}
}
