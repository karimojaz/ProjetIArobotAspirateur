package environnement;

public class Grid implements Runnable {
	// Grid of the environment with the functions that generate randomly dust and
	// jewels

	// attributes
	Box[][] grid;
	int mesureDePerformance;
	boolean environmentRunning;

	// Constructor
	public Grid(Box[][] g) {
		grid = g;
		mesureDePerformance = 0;
		environmentRunning = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = new Box(0, 0, i, j);
			}
		}
	}

	public Grid clone() {
		Grid res=new Grid(new Box[10][10]);
		res.grid = this.getGrid();
		res.mesureDePerformance = this.getMesureDePerformance();
		res.environmentRunning = this.environmentRunning;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				res.setBoxI(i, j, this.getBoxI(i, j));
			}
		}
		return res;
	}

	// Getter and setter
	public Box getBoxI(int i, int j) {
		return (grid[i][j]);
	}
	public void setBoxI(int i, int j, Box box) {
		grid[i][j]=box;
	}

	public Box[][] getGrid() {
		return grid;
	}

	public int getMesureDePerformance() {
		return mesureDePerformance;
	}

	public void setMesureDePerformance(int mesureDePerformance) {
		this.mesureDePerformance = mesureDePerformance;
	}

	// Other Methods
	public void generateEnvironment() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j].generateJewel();
				grid[i][j].generateDirt();
			}
		}
	}

	@Override
	public void run() {// Method that indicate what the thread will do
		while (environmentRunning) {
			generateEnvironment();
		}
	}
}
