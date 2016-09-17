package RoundTracking.DisplayScoreCard;

import RoundTracking.PlayerScore;

public class AddRowToScoreCardNet extends AddRowToScoreCard {

	PlayerScore playerScore;
	
	public AddRowToScoreCardNet(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayerName() + " Net";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}
	
	@Override
	public int getValue(int i) {
		return playerScore.getNetScoreForHole(i);
	}

}
