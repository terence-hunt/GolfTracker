package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;
import RoundTracking.PlayerScore;

public class AddRowToScoreCardNet extends AddRowToScoreCardScore {
	
	public AddRowToScoreCardNet(PlayerScore playerScore, GolfCourse course){
		this.playerScore = playerScore;
		this.course = course;
		this.rowName = playerScore.getPlayer().getPlayerName() + " Net";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}
	
	@Override
	public int getValue(int i) {
		return playerScore.getNetScoreForHole(i);
	}
}
