import java.awt.Color;

import javax.swing.JFrame;

import grid.Grid;

public class Dragon {


	public static void main(String[] args) {
		new Dragon().init();
	}

	private void init() {
		//These sizes should be even
		Grid g = new Grid(4, 200, true);
		JFrame f = new JFrame("Heighway Dragon Fractal");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initial square
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				g.drawRect(i, j, Grid.GREEN);
			}
		}

		new Thread(new Runnable() {
			public void run() {
				shift(g, 1);
			}
		}).start();

		f.getContentPane().add(g);
		f.pack();
		f.setVisible(true);
	}

	private void shift(Grid g, int count) {
		try {
			//"animation" delay
			System.out.println("Sleep");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//create new grid with cells half size, but double in number
		Grid g2 = new Grid(g.getGridSize() * 2, g.getSquareHeight() / 2, true);

		//copy old grid over
		int size = g.getGridSize();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Color tmp = g.get(i, j);

				g2.drawRect(i * 2, j * 2, tmp);
				g2.drawRect(i * 2, j * 2 + 1, tmp);
				g2.drawRect(i * 2 + 1, j * 2, tmp);
				g2.drawRect(i * 2 + 1, j * 2 + 1, tmp);
			}
		}

		//then shift
		int size2 = g2.getGridSize();
		if (count % 2 == 0) {
			for (int i = 0; i < size2; i++) {// rows
				for (int j = 0; j < size2; j++) {// cols
					
				}
			}
		} else {
			// vertical
		}

		if (count != 4) { //finite iterations
			g.setGrid(g2);
			g.setCellSize(g2.getSquareWidth(), g2.getSquareHeight());

			shift(g, ++count);
		}
	}
}
