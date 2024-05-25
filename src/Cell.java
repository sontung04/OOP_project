package OOP;

public class Cell extends Position {
       public enum CellStatus {Occupied, Empty,Hited}
       private CellStatus cellStatus; 
       private Ship shipAtCell;
       
	public Cell(int x, int y) {
		super(x,y);
		this.cellStatus = CellStatus.Empty;
		this.shipAtCell = null;
		
	}
	public CellStatus getCellStatus() {
		return cellStatus;
	}
	public void setCellStatus(CellStatus cellStatus) {
		this.cellStatus = cellStatus;
	}
	public boolean isShip() {
        return shipAtCell != null;
	} 
	public void setShip(Ship ship) {
        this.shipAtCell = ship;
    }
}
