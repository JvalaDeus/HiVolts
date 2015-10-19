import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Grid extends JFrame {
	private static final long serialVersionUID = 1L;
	int numRows = 12;
	int numColumns = 12;
	int[][] cells = new int[numRows][numColumns];
	int xOffset = 3;
	int yOffset = 35;
	int fence = 1;

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
					cells[horiBox][column] = fence;
				}
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
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth, cellHeight, this);
					g2.finalize();
				}
				g.drawRect(xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth, cellHeight);
			}
		}
	}
}