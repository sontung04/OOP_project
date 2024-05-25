package OOP;

public class Player {
     public enum Attack { Hited, Missed}
     private Attack attack;
     private String name;
     private int score;
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
     
}
