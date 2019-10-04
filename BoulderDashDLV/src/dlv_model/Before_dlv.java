package dlv_model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("before")
public class Before_dlv {


	@Param(0)   				
	private int row; 			
	@Param(1)
	private int column;
	
	public Before_dlv(int r,int c){
		this.row=r;
		this.column=c;
	}
	
	public Before_dlv() {
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
