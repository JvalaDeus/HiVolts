import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Grid extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	int numRows = 12;
	int numColumns = 12;
	int[][] cells = new int[numRows][numColumns];
	int xOffset = 3;
	int yOffset = 35;
	int unoccupied = 0;
	int FenceNum = 1;
	int playerNum = 2;
	int mhoNum = 3;
	int min = 0;
	int max = 11;

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
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				if (column == 0 || column == 11 || horiBox == 0 || horiBox == 11) {
					cells[horiBox][column] = FenceNum;
				} else {
					cells[horiBox][column] = unoccupied;
				}
			}
		}
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				System.out.println(cells[horiBox][column] + " " + horiBox + " " + column + "before");
			}
		}
		randSpawner();
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				System.out.println(cells[horiBox][column] + " " + horiBox + " " + column + "after");
			}
		}
		repaint();
	}

	public void randSpawner() {
		int randX;
		int randY;
		for (int Mhos = 0; Mhos < 12; Mhos++) {
			while (true) {
				randX = randInt(min, max);
				randY = randInt(min, max);
				if (cells[randX][randY] == unoccupied) {
					cells[randX][randY] = mhoNum;
					System.out.println("mho" + randX + "" + randY);
					break;
				}
			}

		}
		for (int fence = 0; fence < 20; fence++) {
			while (true) {
				randX = randInt(min, max);
				randY = randInt(min, max);
				if (cells[randX][randY] == unoccupied) {
					cells[randX][randY] = FenceNum;
					System.out.println("fence" + randX + "" + randY);
					break;
				}
			}
		}

		while (true) {
			randX = randInt(min, max);
			randY = randInt(min, max);
			if (cells[randX][randY] == unoccupied) {
				cells[randX][randY] = playerNum;
				System.out.println("player" + randX + "" + randY);
				break;
			}
		}
	}

	public void paint(Graphics g) {
		int cellWidth = getWidth() / 12;
		int cellHeight = getHeight() / 13;
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				if (cells[horiBox][column] == FenceNum) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("download.jpg");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
				}
				if (cells[horiBox][column] == mhoNum) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("mho.jpg");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
				}
				if (cells[horiBox][column] == playerNum) {
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {

		}
		if (e.getKeyCode() == KeyEvent.VK_A) {

		}
		if (e.getKeyCode() == KeyEvent.VK_S) {

		}
		if (e.getKeyCode() == KeyEvent.VK_D) {

		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {

		}
		if (e.getKeyCode() == KeyEvent.VK_E) {

		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {

		}
		if (e.getKeyCode() == KeyEvent.VK_C) {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}