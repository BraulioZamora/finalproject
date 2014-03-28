package finalproyect;

public class Cells {	
	Boolean isFlag;
	Boolean isMine = false;
	char typeCell;
	Boolean isUncover= false;
	int minasCerca;
	
	void uncover(int row, int col);{
		if (this.isUncover=false && )
		if(this.ThereIsMine = True)
		 {
			
		 }
	
	}
	
	void flagAsMine(int row, int col);{
		this.isFlag = true;
	}
	
	void clearFlag(int row, int col);{
		this.isFlag = false;
	}
	
	public void colocarMina(){
		this.isMine = True
	}
    boolean ThereIsMine(){
    return isMine;
    }
    
    public void setValue(int minasCerca)
    {
    	this.minasCerca = minasCerca
    }
    
    public int getValue()
    {
    	return minasCerca
    }
   
}
