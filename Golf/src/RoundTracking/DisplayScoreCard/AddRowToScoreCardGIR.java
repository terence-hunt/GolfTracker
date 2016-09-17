package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;
import RoundTracking.PlayerScore;

public class AddRowToScoreCardGIR extends AddRowToScoreCard {

	PlayerScore playerScore;
	GolfCourse course;

	public AddRowToScoreCardGIR(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayerName() + " GIR";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}

	public String getRow() {
		this.addCell(rowName, true, false);

		for(int i=1 ; i<=noOfColumns ; i++){
			this.addCell(getString(i), false, false);
			if(i%9 == 0) {
				addTotal(i);
			}
		}
		addGrandTotal();
		return htmlString;
	}


	public String getString(int i) {
		if(playerScore.getGIRForHole(i)){
			return "Y";
		}
		return "N";
	}

	@Override
	public int getValue(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addTotal(int i){
		int total = 0;
		for(int hole=i ; hole > i-9 ; hole--){
			if(playerScore.getGIRForHole(hole)){
				total += 1;
			}
		}
		this.addCell(total,false,false);
	}

	public void addGrandTotal(){
		int grandTotal = 0;
		for(int hole =1 ; hole<=noOfColumns ; hole++){
			if(playerScore.getGIRForHole(hole)){
				grandTotal += 1;
			}
		}
		this.addCell(grandTotal,false,true);
	}


}
