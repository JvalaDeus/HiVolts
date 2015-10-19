import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Grid extends JFrame {
	private static final long serialVersionUID = 1L;
	int numRows = 12;
	int numColumns = 12;
	int[][] cells = new int[numRows][numColumns];
	int xOffset = 3;
	int yOffset = 35;
	int unoccupied = 0;
	int fence = 1;
	int player = 2;
	int mho = 3;
	int min = 1;
	int max = 10;

	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.setVisible(true);
		grid.setResizable(false);
	}

	public Grid() {
		init();
	}

	public void init() {
		setSize(600, 600);
		// cells[numRows][numColumns] = unoccupied;
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				if (column == 0 || column == 11 || horiBox == 0 || horiBox == 11) {
					cells[horiBox][column] = fence;
				}
			}
			for (int Mhos = 0; Mhos < 12; Mhos++) {
				cells[randInt(min, max)][randInt(min, max)] = mho;
			}
			for (int insideFences = 0; insideFences < 20; insideFences++) {
				cells[randInt(min, max)][randInt(min, max)] = fence;
			}
			for (int you = 0; you < 1; you++) {
				cells[randInt(min, max)][randInt(min, max)] = player;
			}
		}
		repaint();
	}

	public void paint(Graphics g) {
		int cellWidth = getWidth() / 12;
		int cellHeight = getHeight() / 13;
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				if (cells[horiBox][column] == fence) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("download.jpg");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
				}
				if (cells[horiBox][column] == mho) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("mho.jpg");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
				}
				if (cells[horiBox][column] == player) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("Player.png");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
					g.drawRect(xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth, cellHeight);
				}
			}
		}
	}

	public static int randInt(int min, int max) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

		return randomNum;
	}
}