package finalproyect;
import java.util.Random;

import com.despegar.highflight.utils.*;;
public class MinesweeperImpl implements Minesweeper{
	Cells [][] grid;
    
    public MinesweeperImpl(int row , int col){
    	Cells[][] grid = new Cells[row][col];
    	int cantidadMinas = (int) Math.rint(grid.length * grid[0].length*0.15);
    }
	public void loadMines(int cantidadMinas)
	  {
			for(int i=0;i<cantidadMinas-1;i++)
		{
		  Matrix2DCellPosition  cellPosition= randomCell();
		  grid [cellPosition.getRow()][cellPosition.getColumn()] = new Cells();
		  
		}
	  }
    
	public Matrix2DCellPosition randomCell(){
		Random rand = new Random();
		int row = rand.nextInt(grid.length);
		int col = rand.nextInt(grid[0].length);
		if ( grid [row][col] == null)
		{
			return new Matrix2DCellPosition (row,col);
		}
		else {
			 return randomCell();
		     }
		
		
    	
    }
	
	
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
		Minesweeper game = new MinesweeperImpl();
		
		game.display();
		while(!(game.isGameOver())){
			
		}
		
	}

}
