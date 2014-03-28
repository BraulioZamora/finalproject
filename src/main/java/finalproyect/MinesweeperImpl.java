package finalproyect;
import java.util.Random;

import com.despegar.highflight.utils.*;;
public class MinesweeperImpl implements Minesweeper{
	Cells [][] grid;
    
    public MinesweeperImpl(int row , int col){
    	Boolean gameOver = false;
    	Cells[][] grid = new Cells[row][col];
    	int cantidadMinas = (int) Math.rint(grid.length * grid[0].length*0.15);
    	int cantidadCeldas;
    }
    
    // cargo minas
	public void loadMines(int cantidadMinas)
	  {
			for(int i=0;i<cantidadMinas-1;i++)
		{
		  Matrix2DCellPosition  cellPosition= randomCell();
		  grid [cellPosition.getRow()][cellPosition.getColumn()] = new Cells();
		  grid [cellPosition.getRow()][cellPosition.getColumn()].colocarMina();

		}
	  }
    
	public Matrix2DCellPosition randomCell()
	 {
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
	//cargo numeros de minas alrededor
	public void loadNumbers()
	  {
	    for(int i=0;i<row; i++)
	    {
		    for(int j=0;j<col;j++)
		       {
		    	if(this.ThereIsMine = false)
		    	{
		    		grid [row][col].setValue(int minasCerca(int row, int col))
		    		
		    	}
		    	
		       }
	    }   
	  }
	
	int minasCerca(int row,int col)
	    {
         int numeroMinas=0;
         for(int i=col-1;i<=col+1;i++){
            	//En horizontal
                if(i>-1 && i<col){
	                if(grid[row][i].ThereIsMine==true){
	             		numeroMinas++;
	                }
                }
            }
            //	En vertical
                for(int j=row-1;j<=row+1;j++){
	                		if(j>-1 && j<row)
	                			if(grid [j][col].ThereIsMine==true){
	                			numeroMinas++;
	                			}
	                	}
	        //	En diagonal
	        //	TODO Posición de la esquina superior izquierda en realidad creo que es inferior
	        int x1=row;
	        int y1=col;
	        x1--;
	        y1--;
	     // TODO no estoy seguro si es  i<x1+3 o i<x1+2 y si es así, porque busqué recorrer en diagonal, y me dio esto pero no termino de entender
	        	for(int i=x1;i<x1+3;i++)
	        		{
	        			if(i>-1 && i<row && y1>-1 && y1<row)
	        			 if(grid [i][y1].ThereIsMine==true){
	             		numeroMinas++;
	                	}
	                	y1++;
	        		}
	        //TODO Posición de la esquina superior derecha
	        x1=row;
	        y1=col;
	        x1--;
	        y1++;
	        
	         // TODO no estoy seguro si es  i<x1+3 o i<x1+2
	        	for(int i=x1;i<x1+3;i++)
	        		{
	        		//
	        			if(i>-1 && i<row && y1>-1 && y1<row)
	        			 if(grid [i][y1].ThereIsMine==true){
	             		numeroMinas++;
	                	}
	                	y1--;
	        		}
            return numeroMinas;
	}
	
    public void uncover(int row, int col) {
    	if (this.cell.ThereIsMine == false && this.cantidadCeldas>= row*col-cantidadMinas)
    	{
		this.cell.uncover(row, col);
    	} else if (this.cell.ThereIsMine == true)
    	   {
    	     this.gameOver = true;
           } else if (this.cell.ThereIsMine == false && this.cantidadCeldas < row*col-cantidadMinas)
           {
        	   this.winingGame =true;
        	   this.gameOver = true;
           }
	}

	public void flagAsMine(int row, int col) {
		this.cell.flagAsMine(row, col);
		
	}

	public void clearFlag(int row, int col) {
	this.cell.clearFlag(row, col);
		
	}

	public boolean isGameOver() {
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



