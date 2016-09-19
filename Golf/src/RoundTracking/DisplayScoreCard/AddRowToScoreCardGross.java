package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;
import RoundTracking.PlayerScore;

public class AddRowToScoreCardGross extends AddRowToScoreCardScore {

	public AddRowToScoreCardGross(PlayerScore playerScore, GolfCourse course){
		this.playerScore = playerScore;
		this.course = course;
		this.rowName = playerScore.getPlayer().getPlayerName() + " gross";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}

	@Override
	public int getValue(int i) {
		return playerScore.getGrossScoreForHole(i);
	}

	@Override
	public void addTotal(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGrandTotal() {
		// TODO Auto-generated method stub
		
	}
}
