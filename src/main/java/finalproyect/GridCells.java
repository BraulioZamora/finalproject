package finalproyect;

import java.util.Random;

public class GridCells 
{
	int row;
	int col;
	int i;
	int j;
	int h;
	Double mines;
	mines =  row *  col * 0.15;
	Cells [][] Grid = new Cells [row][col];

	
	
	for(i=0;i<row-1; i++)
	   {
	    for(j=0;j<col-1;j++)
	       {	    	
		    for(h=0;h<mines-1;h++)
		         {
		    	  Random rand = new Random();
			      int value = rand.nextInt(h);
			     }
		     
		   }
	    for(i=0;i<row-1; i++)
		   {
		    for(j=0;j<col-1;j++)
		       {
		    	if(!(this.getValue(Value).equals(-1)))
		       	   { 
		 	         this.getValue(value);
			       } 
		
	           }

      }
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public Double getValue(){
		return this.value;
	}
}
}