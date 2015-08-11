import java.awt.Color;

import javax.swing.JFrame;

import grid.Grid;

public class Dragon {
	private static final int DELAY_TIME = 2000;

	public static void main(String[] args) {
		new Dragon().init();
	}

	private void init() {
		//These sizes should be even
		Grid g = new Grid(7, 100, true);
		JFrame f = new JFrame("Heighway Dragon Fractal");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initial square
		for (int i = 1; i <= 3; i++) {
			for (int j = 3; j <= 4; j++) {
				g.drawRect(i, j, Grid.GREEN);
			}
		}

		f.getContentPane().add(g);
		f.pack();
		f.setVisible(true);

		//first shift done manually
		delay(DELAY_TIME);
		g.clearGrid();
		g.drawRect(1, 2, Grid.GREEN);
		g.drawRect(1, 3, Grid.GREEN);
		g.drawRect(1, 2, Grid.GREEN);
		g.drawRect(2, 2, Grid.GREEN);

		new Thread(new Runnable() {
			public void run() {
				shift(g, 0);
			}
		}).start();


	}

	private void shift(Grid g, int count) {
		delay(DELAY_TIME);

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
		if (count % 2 == 0) { // alternate direction
			for (int i = 0; i < size2; i++) {// rows
				for (int j = 0; j < size2; j++) {// cols

				}
			}
		} else {
			// vertical
		}

		if (count != 3) { //finite iterations
			g.setGrid(g2);
			g.setCellSize(g2.getSquareWidth(), g2.getSquareHeight());

			shift(g, ++count);
		}
	}

	private void delay(int ms) {
		try {
			//"animation" delay
			System.out.println("Sleep");
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
