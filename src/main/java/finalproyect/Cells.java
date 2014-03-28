package finalproyect;

public class Cells {	
	boolean isFlag = false;
	boolean isMine = false;
	char typeCell;
	boolean isUncover= false;
	int minasCerca;
	
	void uncover()
	    {
    	this.isUncover = true;
	    }
	
	boolean isUncover()
     	{
        return isUncover;
	    } 
	
	void flagAsMine(int row, int col)
	    {
		this.isFlag = true;
	    } 
	
	void clearFlag(int row, int col)
	    {
		this.isFlag = false;
     	}
	
	public boolean isFlag()
	 {return isFlag;}
	 
	public void colocarMina()
	    {
		this.isMine = true;
	    }
    
	boolean ThereIsMine()
	    {
         return isMine;
        }
    
    public void setValue(int minasCerca)
        {
    	this.minasCerca = minasCerca;
        }
    
    public int getValue()
        {
    	return minasCerca;
        }
   
}
