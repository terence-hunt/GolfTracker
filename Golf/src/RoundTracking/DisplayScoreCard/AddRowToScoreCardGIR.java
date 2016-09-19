package RoundTracking.DisplayScoreCard;

import RoundTracking.PlayerScore;

public class AddRowToScoreCardGIR extends AddRowToScoreCardString {

	public AddRowToScoreCardGIR(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayer().getPlayerName() + " GIR";
		this.noOfColumns = playerScore.getPlayersScores().size();
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

	@Override
	public String getValue(int i) {
		if(playerScore.getGIRForHole(i)){
			return "Y";
		}
		return "N";
	}
}
