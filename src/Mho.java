public class Mho extends Grid {
	int directionX;
	int directionY;
	int originalMhoPositionX;
	int originalMhoPositionY;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Mho();
	}

	public Mho() {
		mhoMovement();
	}

	public void mhoMovement() {
		int newX = 0;
		int newY = 0;

		for (int horiBox = 0; horiBox < 12; horiBox++) {
			for (int column = 0; column < 12; column++) {
				if (cells[horiBox][column] == mhoNum) {
					System.out.println("found a mho");
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
		System.out.println("Going to repaint now");
		repaint();
	}
}