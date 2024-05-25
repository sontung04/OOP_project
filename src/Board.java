package OOP;

import java.util.ArrayList;
import java.util.List;

public class Board extends Position{
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Cell[][] cells = new Cell[WIDTH][HEIGHT];;
	private List<Ship>ships;
	private boolean showShip;
	private boolean allShipDestroy;
	public Board(int x, int y) {
		super(x,y);
		this.ships = new ArrayList<Ship>();
		this.showShip = false;
		this.allShipDestroy = false;
	}
	public Cell[][] getCells() {
		return cells;
	}
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	public boolean isShowShip() {
		return showShip;
	}
	public void setShowShip(boolean showShip) {
		this.showShip = showShip;
	}
	public boolean areAllShipDestroy() {
		return allShipDestroy;
	}
	public void setAllShipDestroy(boolean allShipDestroy) {
		this.allShipDestroy = allShipDestroy;
	}
	public boolean canPlaceShipAt(int gridX, int gridY, int segments, boolean sideways) {
        if(gridX < 0 || gridY < 0) return false;

        if(sideways) { // nếu tàu nằm ngang
            if(gridY > HEIGHT || gridX + segments > WIDTH) return false;
            for(int x = 0; x < segments; x++) {
                if(cells[gridX+x][gridY].isShip()) return false;
            }
        } else { // nếu tàu nằm dọc
            if(gridY + segments > HEIGHT || gridX > WIDTH) return false;
            for(int y = 0; y < segments; y++) {
                if(cells[gridX][gridY+y].isShip()) return false;
            }
        }
        return true;
    }
	
   
   public void removeShip() {
	  for(Ship i : ships) {
		  if(i.isSunk()) {
			  this.ships.remove(i);
		  }
	  }
   }
   public void placeShip(int gridX, int gridY, int shipType, boolean sideways) {
       placeShip(new Ship(new Position(gridX, gridY), shipType, sideways ), gridX, gridY);
   }

   public void placeShip(Ship ship, int gridX, int gridY) {
       ships.add(ship);
       if(ship.isSideWays()) { 
           for(int x = 0; x < ship.getShipType(); x++) {
               cells[gridX+x][gridY].setShip(ships.get(ships.size()-1));
           }
       } else {
           for(int y = 0; y < ship.getShipType(); y++) {
               cells[gridX][gridY+y].setShip(ships.get(ships.size()-1));
           }
       }
   }
 }
    
