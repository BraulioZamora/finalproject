package finalproyect;

import java.util.Random;
import java.util.Set;

import com.despegar.highflight.utils.*;

import java.util.Scanner;

public class MinesweeperImpl implements Minesweeper {
	Cells[][] grid;
	Boolean gameOver = false;
	Boolean winningGame = false;
	int cantidadMinas;
	int[][] gridRaw;
	Random rand = new Random();
	int cantidadCeldas;
	

	public MinesweeperImpl(int row, int col) {
		gridRaw = new int[row][col];
		grid = new Cells[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int numInicial = 0;
				grid[i][j] = new Cells();
				grid[i][j].setValue(numInicial);
			}
		}
		cantidadMinas = (int) Math.rint(grid.length * grid[0].length * 0.15);
		loadMines(cantidadMinas);
		loadNumbers(row, col);
		cantidadCeldas = this.getRow() * this.getCol();
	}

	public int getRow() {
		return grid.length;
	}

	public int getCol() {
		return grid[0].length;
	}

	// random
	public Matrix2DCellPosition randomCell() {
		int row = rand.nextInt(this.getRow());
		int col = rand.nextInt(this.getCol());

		while (grid[row][col].ThereIsMine()) {
			row = rand.nextInt(this.getRow());
			col = rand.nextInt(this.getCol());
		}
		return new Matrix2DCellPosition(row, col);

	}

	// cargo minas
	public void loadMines(int cantidadMinas) {

		for (int i = 0; i < cantidadMinas; i++) {

			Matrix2DCellPosition cellPosition = randomCell();
			grid[cellPosition.getRow()][cellPosition.getColumn()].colocarMina();
			grid[cellPosition.getRow()][cellPosition.getColumn()].setValue(-1);

		}
	}

	// cargo números de minas alrededor
	public void loadNumbers(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j].getValue() == 0) {
					int valor = minasCerca(i, j);
					grid[i][j].setValue(valor);

				}

			}
		}
	}

	// obtengo cantidad de minas cerca
	int minasCerca(int row, int col) {
		int numeroMinas = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++)
				if (i > -1 && i < this.getRow() && j > -1 && j < this.getCol()) {
					if (grid[i][j].ThereIsMine()) {
						numeroMinas++;
					}
				}
		}

		return numeroMinas;
	}

	public void uncover(int row, int col) {
		if (this.grid[row][col].ThereIsMine()) {
			this.gameOver = true;}
			else if (cantidadCeldas > (this.getRow() * this.getCol())- cantidadMinas) {
			this.grid[row][col].uncover();
			cantidadCeldas--;
			/*
			 * if(this.grid [row][col].getValue() == 0) { Set
			 * <Matrix2DCellPosition> cascada = cascade(row,col); for
			 * (Matrix2DCellPosition matrix2dCellPosition : cascada) {
			 * this.uncover
			 * (matrix2dCellPosition.getRow(),matrix2dCellPosition.getColumn());
			 * 
			 * } }
			 */
		   }  
			else {this.winningGame = true;
		         this.gameOver = true;
		        }
		}
	

	/*
	 * private Set<Matrix2DCellPosition> cascade(int row, int col){ return
	 * MatrixUtils.cascade(gridRaw, row, col); }
	 */

	public void flagAsMine(int row, int col) {
		this.grid[row][col].flagAsMine(row, col);

	}

	public void clearFlag(int row, int col) {
		this.grid[row][col].clearFlag(row, col);

	}

	// retorno si es game over
	public boolean isGameOver() {
		return gameOver;
	}

	// retorno si gano el juego
	public boolean isWinningGame() {
		return winningGame;
	}

	public void displayContador(){
		System.out.println(cantidadCeldas);
	}
	// genero matriz binaria
	public void gridRaw() {
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getCol(); j++) {
				if (this.grid[i][j].ThereIsMine()) {
					this.gridRaw[i][j] = 1;
				} else {
					this.gridRaw[i][j] = 0;
				}

			}
		}
	}

	public void display() {
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getCol(); j++) {
				if (this.grid[i][j].isFlag){
					System.out.print("F");
					
				} else if (this.grid[i][j].isUncover()) {
					System.out.print(this.grid[i][j].getValue());
				} else {
					System.out.print('-');
				}
			}
			System.out.println();
		}

	}

	public void displayInternal() {

		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getCol(); j++) {
				if (this.grid[i][j].ThereIsMine()) {
					System.out.print("M ");
				} else {
					System.out.print(this.grid[i][j].getValue() + " ");
				}
			}
			System.out.println();
		}
	}

	public void displayRaw() {
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getCol(); j++) {
				System.out.print(gridRaw[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int row;
		int col;
		String accion;
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese valor de filas y columnas");
		row = scan.nextInt();
		col = scan.nextInt();
		MinesweeperImpl game = new MinesweeperImpl(row, col);

		game.display();
		game.displayInternal();
		game.displayRaw();
		game.displayContador();
		while (!(game.isGameOver())) {
			System.out.println("ingrese número fila");
			row = scan.nextInt();
			System.out.println("ingrese número columna");
			col = scan.nextInt();
			System.out
					.println("ingrese acción u:(uncover)/f:(flag)/c:(clear flag)");
			accion = scan.next();
			switch (accion.charAt(0)) {
			case 'u':
				game.uncover(row, col);
			case 'f':
				game.flagAsMine(row, col);
			case 'c':
				game.clearFlag(row, col);
			}
			game.display();
			game.displayContador();
			
		}
		if (game.isWinningGame()) {
			System.out.println("Ganaste!!!");
		} else{System.out.println("perdiste");}
	}

}
