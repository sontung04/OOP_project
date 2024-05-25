package OOP;

public class Ship {
     public enum ShipStatus {Sunk,Hited,Safe}
     //Nằm ngang trả về true
     private boolean isSideWays;
     private ShipStatus shipStatus;
     // số phân đoạn tàu
     private int shipType;
     private int destroyedSections;
     private Position position;
	public Ship(Position position,int shipType,boolean isSideWays) {
		this.position = position;
		this.isSideWays = isSideWays;
		this.shipStatus = ShipStatus.Safe;
		this.shipType = shipType;
		this.destroyedSections = 0;
	}
	public boolean isSideWays() {
		return isSideWays;
	}
	public void setSideWays(boolean isSideWays) {
		this.isSideWays = isSideWays;
	}
	public ShipStatus getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(ShipStatus shipStatus) {
		this.shipStatus = shipStatus;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getShipType() {
		return shipType;
	}
	public void setShipType(int shipType) {
		this.shipType = shipType;
	}
	public int getDestroyedSections() {
		return destroyedSections;
	}
	public void setDestroyedSections(int destroyedSections) {
		this.destroyedSections = destroyedSections;
	}
	public void isHited() {
		this.setShipStatus(ShipStatus.Hited);
		this.destroyedSections++;
	}
	public boolean isSunk() {
		boolean check = this.destroyedSections >= this.shipType;
		if(check) {
			this.setShipStatus(ShipStatus.Sunk);
			return true;
		}
		return false;
	}
     
}
