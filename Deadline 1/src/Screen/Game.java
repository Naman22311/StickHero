

import java.util.ArrayList;

public class Game extends GameMech  {
	
	private int score; 
	private int PowerupsCollected;
	Player Player;
	public ArrayList<Cherry>cherries = new ArrayList();
	public ArrayList<Pillar>pillars = new ArrayList();
	
	public void start() {
		
	}
	
	public void restart() {
			
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPowerupsCollected() {
		return PowerupsCollected;
	}

	public void setPowerupsCollected(int powerupsCollected) {
		PowerupsCollected = powerupsCollected;
	}

	public Player getPlayer() {
		return Player;
	}

	public void setPlayer(Player player) {
		Player = player;
	}

	public ArrayList<Cherry> getCherries() {
		return cherries;
	}

	public void setCherries(ArrayList<Cherry> cherries) {
		this.cherries = cherries;
	}

	public ArrayList<Pillar> getPillars() {
		return pillars;
	}

	public void setPillars(ArrayList<Pillar> pillars) {
		this.pillars = pillars;
	}
	
	
	
	
}
