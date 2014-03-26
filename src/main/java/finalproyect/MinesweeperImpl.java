package finalproyect;

public class MinesweeperImpl implements Minesweeper{
	Cells cell;

	public void uncover(int row, int col) {
		this.cell.uncover(row, col);
		
	}

	public void flagAsMine(int row, int col) {
		this.cell.flagAsMine(row, col);
		
	}

	public void clearFlag(int row, int col) {
	this.cell.clearFlag(row, col);
		
	}

	public boolean isGameOver() {
	if (this.cell.ThereIsMine()){
		return true;
	} else {return false;}
	}

	public boolean isWinningGame() {
		if( this.isGameOver() && this.cell.){
			return true;
		}
		return false;
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public void displayInternal() {
		// TODO Auto-generated method stub
		
	}

	public void displayRaw() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		int row;
		int col;
		Minesweeper game = new MinesweeperImpl();
		Cells[][] grid = new Cells[row][col]; 
		game.display();
		while(!(game.isGameOver())){
			
		}
		
	}

}
