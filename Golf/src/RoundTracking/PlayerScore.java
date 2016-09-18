package RoundTracking;
import java.util.ArrayList;

import PlayerData.Player;

public class PlayerScore {
	Player player;
	ArrayList<ScoreForHole> scores = new ArrayList<ScoreForHole>();	

	public PlayerScore(Player player){
		this.player = player;
	}
	
	public PlayerScore(Player player, ArrayList<ScoreForHole> score){
		this.player = player;
		this.scores = score;
	}
	
	public void setScoreforHole(int holeNumber,int netScore, int numberOfPutts, String FIR){
		if(scores.get(holeNumber-1) != null){
			scores.get(holeNumber).setScore(holeNumber, netScore, numberOfPutts, FIR);
		}
		else {
			ScoreForHole tmp = new ScoreForHole();
			tmp.setScore(holeNumber, netScore, numberOfPutts, FIR);
			scores.add(new ScoreForHole(holeNumber, netScore, numberOfPutts, FIR));	
		}
	}
	public String getPlayerName(){
		return player.getPlayerName();
	}
	public ArrayList<ScoreForHole> getPlayersScores(){
		return scores;
	}

	public int getNetScoreForHole(int holeNumber){
		return scores.get(holeNumber - 1).getNetScore();
	}
	public int getGrossScoreForHole(int holeNumber){
		return scores.get(holeNumber - 1).getGrossScore();
	}
	public int getPuttsForHole(int holeNumber){
		return scores.get(holeNumber - 1).getNumberOfPutts();
	}
	public boolean getGIRForHole(int holeNumber){
		return scores.get(holeNumber - 1).getGIR();
	}
}
