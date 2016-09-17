package RoundTracking.DisplayScoreCard;

import RoundTracking.PlayerScore;

public class AddRowToScoreCardGross extends AddRowToScoreCard {

	PlayerScore playerScore;
	
	public AddRowToScoreCardGross(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayerName() + " gross";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}
	
	@Override
	public int getValue(int i) {
		return playerScore.getGrossScoreForHole(i);
	}

}
