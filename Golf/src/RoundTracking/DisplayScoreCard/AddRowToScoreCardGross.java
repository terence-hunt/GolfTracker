package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;
import RoundTracking.PlayerScore;

public class AddRowToScoreCardGross extends AddRowToScoreCard {

	PlayerScore playerScore;
	GolfCourse course;

	public AddRowToScoreCardGross(PlayerScore playerScore, GolfCourse course){
		this.playerScore = playerScore;
		this.course = course;
		this.rowName = playerScore.getPlayerName() + " gross";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}

	@Override
	public int getValue(int i) {
		return playerScore.getGrossScoreForHole(i);
	}

	public String getRow() {
		this.addCell(rowName, true, false);

		for(int i=1 ; i<=noOfColumns ; i++){
			if(getValue(i) < course.getPar(i)){
				this.addBirdyCell(getValue(i));
			}
			else if(getValue(i) > course.getPar(i)){
				this.addBogeyCell(getValue(i));
			}
			else {
				this.addCell(getValue(i), false, false);
			}
			if(i%9 == 0) {
				addTotal(i);
			}
		}
		addGrandTotal();
		return htmlString;
	}

	public void addBirdyCell(int string){
		htmlString += HTML_BEGIN;
		htmlString += "<div class=\"circle_birdy\">" + string + "</div>";
		htmlString += HTML_END;
	}
	public void addBogeyCell(int string){
		htmlString += HTML_BEGIN;
		htmlString += "<div class=\"circle_bogey\">" + string + "</div>";
		htmlString += HTML_END;
	}

}
