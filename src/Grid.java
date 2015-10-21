import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;

/**
 * This class is basically holds 90% of the code for my project. It holds the
 * creation of the grid, the painting of the grid, spawning of the characters,
 * and the movement of the characters. It also holds the deletion rules, and
 * calls the youWin or youLose classes, depending on the situation.
 */
public class Grid extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	// total amount of rows and columns, used to create a 2D grid that creates
	// all 144 cells.
	int numRows = 12;
	int numColumns = 12;
	int[][] cells = new int[numRows][numColumns];

	// stores the players cell information
	int[] playerCell = new int[2];
	
	//stores the mhos' cells informations
	int[][] mhoCoord = new int[12][2];
	int[] mhoStatus = new int[12];

	// the offset for the creation of the grid
	int xOffset = 3;
	int yOffset = 35;

	// numbers that tell the paint method what to paint onto that specific cell.
	// if the cell = 2 for example, it paints the player on it
	int unoccupied = 0;
	int FenceNum = 1;
	int playerNum = 2;
	int mhoNum = 3;
	
	//status of the mhos
	int dead = 0;
	int alive = 1;

	// min and max for the random number function used for the random spawning
	// of characters, and the jump function
	int min = 0;
	int max = 11;

	// used to determine which way the mho moves.
	int directionX;
	int directionY;

	// the original coordinates of the mho, so the program knows the original
	// coordinates are now equal to unoccupied and paints it as such
	int originalMhoPositionX;
	int originalMhoPositionY;

	// instances of the youlose/win classes
	YouLose gameOver = new YouLose();
	YouWin gameWon = new YouWin();

	/**
	 * This is the main. It creates the grid and allows it to be seen, and
	 * closed. But it makes it so you cannot change the size.
	 */
	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.setVisible(true);
		grid.setResizable(false);
	}

	// the constructor of the grid class. calls the init class
	public Grid() {
		init();
	}

	/**
	 * the init class. It sets the size of the grid. then it adds the
	 * keyListener, so you can move in the game by hitting a key. After that it
	 * creates two for loops so it can run through the grid again. When it runs
	 * through, it sets the perimeter cells to be equal to a fence, while the
	 * others are equal to unoccupied. It then calls the random spawner, then
	 * the repaint method. Therefore all the cells in the grid are set to a
	 * certain number. Each number tells the paint method what to draw in that
	 * grid.
	 */
	public void init() {
		setSize(600, 600);
		this.addKeyListener(this);
		for (int column = 0; column < 12; column++) {
			for (int horiBox = 0; horiBox < 12; horiBox++) {
				if (column == 0 || column == 11 || horiBox == 0 || horiBox == 11) {
					cells[horiBox][column] = FenceNum;
				} else {
					cells[horiBox][column] = unoccupied;
				}
			}
		}
		randSpawner();
		repaint();
	}

	/**
	 * The randSpawner is the class that spawns each character randomly. I have
	 * two ints called randX/randY because they call the randInt method. It then
	 * goes trhough a for loop for the Mhos, giving each mho a random cell to be
	 * spawned into. It then does the same for the fences and the players. IT
	 * does this by calling a random number for x and y, then uses those
	 * coordinates to find a cell, and give that cell the number of a fence,
	 * mho, or player. It also has a while loop because I do not want any
	 * character to spawn on another character, so the while loop prevents that.
	 */
	public void randSpawner() {
		int randX;
		int randY;
		int mhoArrayIndex = 0;
		
		for (int Mhos = 0; Mhos < 12; Mhos++) {
			while (true) {
				randX = randInt(min, max);
				randY = randInt(min, max);
				if (cells[randX][randY] == unoccupied) {
					cells[randX][randY] = mhoNum;
					mhoCoord[mhoArrayIndex][0] = randX;
					mhoCoord[mhoArrayIndex][1] = randY;
					mhoStatus[mhoArrayIndex] = alive;
					mhoArrayIndex++;
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
					break;
				}
			}
		}

		while (true) {
			randX = randInt(min, max);
			randY = randInt(min, max);
			if (cells[randX][randY] == unoccupied) {
				cells[randX][randY] = playerNum;
				playerCell[0] = randX;
				playerCell[1] = randY;
				break;
			}
		}
	}

	/**
	 * This is the paint method. First, it sets the height and width of each
	 * cell as a ratio of the size of the window. Then it goes into a double
	 * nested for loop which runs through the grid, looking for the number of
	 * each cell. As stated before, it paints the corresponding image to each
	 * number. The unoccupied(0) image is grass, the FenceNum(1) is a fence
	 * (naturally), the playerNum(2) is a cow, and the mhoNum(3) is a butcher.
	 */
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
				if (cells[horiBox][column] == unoccupied) {
					Graphics2D g2 = (Graphics2D) g;
					Image fenceImage = Toolkit.getDefaultToolkit().getImage("Grass.jpg");
					g2.drawImage(fenceImage, xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth,
							cellHeight, this);
					g2.finalize();
					g.drawRect(xOffset + horiBox * cellWidth, column * cellHeight + yOffset, cellWidth, cellHeight);
				}
			}
		}
	}

	/**
	 * This is the previously mentioned random number generator. it has two
	 * parameters, a minimum number and a max number. This is because it is
	 * supposed to be used to find a cell for the random spawning. But it cannot
	 * spawn on or outside the perimeter, so the min is 1 and the max is 11.
	 * then it takes the number and stores it.
	 */
	public static int randInt(int min, int max) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

		return randomNum;
	}
/**
	public void mhoMovement() {
		int newX = 0;
		int newY = 0;
		int foundAMho = 0;

		for (int horiBox = 0; horiBox < 12; horiBox++) {
			for (int column = 0; column < 12; column++) {
				if (cells[horiBox][column] == mhoNum) {
					foundAMho = 1;
					originalMhoPositionX = horiBox;
					originalMhoPositionY = column;
					if (horiBox == playerCell[0]) {
						directionY = (column - playerCell[1]);
						if (directionY > 0) {
							newX = horiBox;
							newY = column - 1;
						}
						if (directionY < 0) {
							newX = horiBox;
							newY = column + 1;
						}
					}
					if (column == playerCell[1]) {
						directionX = (horiBox - playerCell[0]);
						if (directionX > 0) {
							newX = horiBox + 1;
							newY = column;
						}
						if (directionX < 0) {
							newX = horiBox - 1;
							newY = column;
						}
					}
					if (horiBox != playerCell[0] && column != playerCell[1]) {
						directionX = horiBox - playerCell[0];
						directionY = column - playerCell[1];
						if (directionX > 0 && directionY > 0) {
							newX = horiBox - 1;
							newY = column - 1;
						}
						if (directionX < 0 && directionY > 0) {
							newX = horiBox + 1;
							newY = column - 1;
						}
						if (directionX > 0 && directionY < 0) {
							newX = horiBox - 1;
							newY = column + 1;
						}
						if (directionX < 0 && directionY < 0) {
							newX = horiBox + 1;
							newY = column + 1;
						}
					}
					if (cells[newX][newY] == playerNum) {
						YouLose.main(null);
					} else if (cells[newX][newY] == FenceNum) {
						cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
					} else if (cells[newX][newY] == unoccupied) {
						cells[newX][newY] = mhoNum;
						cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
					}
				}
			}
		}
		System.out.println(foundAMho);
		if (foundAMho == 0) {
			YouWin.main(null);
		}
		repaint();
	}
*/
	/**
	 * Here is the player movement. The player cell array now sets the [0] to
	 * the x and the [1] to the y. What happens is that now when you hit
	 * WASDQEZCJ, it has a corresponding thing to do. For instance, hitting W
	 * now subtracts one from your y or playerCell[1] and leaves the x, or
	 * playerCell[0], alone. It does something similar for each key. However,
	 * before any of this happens, it stores the original x,y. then it sets the
	 * original x,y to unoccupied and the new x,y to playerNum. When you hit the
	 * J key, to jump, it goes through a while loop. This is to prevent you from
	 * landing on a fence, which is not allowed. It allows you to land on an
	 * unoccupied space, or a mho (and die). Finally, the keyPressed has it set
	 * so that if the new x,y is equal to mhoNum and FenceNum, it ends the game
	 * and goes to the YouLose class which displays the message you lose and
	 * asks if you want to play again. If the new space is unoccupied, it paints
	 * you onto that space, and then runs the movement of the mhos.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int originalX = playerCell[0];
		int originalY = playerCell[1];

		if (e.getKeyCode() == KeyEvent.VK_W) {
			playerCell[0] = playerCell[0];
			playerCell[1] = playerCell[1] - 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			playerCell[0] = playerCell[0] - 1;
			playerCell[1] = playerCell[1];
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			playerCell[0] = playerCell[0];
			playerCell[1] = playerCell[1] + 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			playerCell[0] = playerCell[0] + 1;
			playerCell[1] = playerCell[1];
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			playerCell[0] = playerCell[0] - 1;
			playerCell[1] = playerCell[1] - 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			playerCell[0] = playerCell[0] + 1;
			playerCell[1] = playerCell[1] - 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			playerCell[0] = playerCell[0] - 1;
			playerCell[1] = playerCell[1] + 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			playerCell[0] = playerCell[0] + 1;
			playerCell[1] = playerCell[1] + 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			playerCell[0] = randInt(min, max);
			playerCell[1] = randInt(min, max);
			while (true) {
				if (cells[playerCell[0]][playerCell[1]] == FenceNum) {
					playerCell[0] = randInt(min, max);
					playerCell[1] = randInt(min, max);
				}
				if (cells[playerCell[0]][playerCell[1]] == unoccupied) {
					cells[playerCell[0]][playerCell[1]] = playerNum;
					cells[originalX][originalY] = unoccupied;
					repaint();
					break;
				}
				if (cells[playerCell[0]][playerCell[1]] == mhoNum) {
					YouLose.main(null);
					break;
				}
			}

		}

		if (cells[playerCell[0]][playerCell[1]] == mhoNum || cells[playerCell[0]][playerCell[1]] == FenceNum) {
			YouLose.main(null);
		} else {
			cells[playerCell[0]][playerCell[1]] = playerNum;
			cells[originalX][originalY] = unoccupied;
			Mho.mhoMovement();
			repaint();
		}
	}

	// Did not use the keyReleased
	@Override
	public void keyReleased(KeyEvent e) {

	}

	// Did not use the keyTyped
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}