package OOP;

public class Game {
      public enum GameStatus {Process, Finished, PlayerTurn,BotTurn,Pause}
      private GameStatus gameStatus;
      Board board;
      Player player;
	public Game() {
		this.gameStatus = gameStatus;
		this.board = board;
		this.player = player;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
      
      
}
