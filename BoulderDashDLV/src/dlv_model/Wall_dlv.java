package dlv_model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("wall")
public class Wall_dlv {


	@Param(0)   				
	private int row; 			
	@Param(1)
	private int column;
	
	public Wall_dlv(int r,int c){
		this.row=r;
		this.column=c;
	}
	
	public Wall_dlv() {
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	
}
