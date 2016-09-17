package RoundTracking.DisplayScoreCard;

import RoundTracking.PlayerScore;

public class AddRowToScoreCardPutts extends AddRowToScoreCard {

	PlayerScore playerScore;
	
	public AddRowToScoreCardPutts(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayerName() + " putts";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}
	
	@Override
	public int getValue(int i) {
		return playerScore.getPuttsForHole(i);
	}

}
