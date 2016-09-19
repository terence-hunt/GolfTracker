package RoundTracking.DisplayScoreCard;

import Data.ConfigurationSettings.FIREnum;
import RoundTracking.PlayerScore;

public class AddRowToScoreCardFIR extends AddRowToScoreCardString {

	public AddRowToScoreCardFIR(PlayerScore playerScore){
		this.playerScore = playerScore;
		this.rowName = playerScore.getPlayer().getPlayerName() + " FIR";
		this.noOfColumns = playerScore.getPlayersScores().size();
	}
	
	@Override
	public String getValue(int i) {
		if(playerScore.getFIRForHole(i) == FIREnum.L){
			return "<--";
		}
		else if(playerScore.getFIRForHole(i) == FIREnum.R){
			return "-->";
		}
		else {
			return "^";
		}
	}
	public void addTotal(int i){
		//add nothing in the totals column
		this.addCell("", false, false);
	}

	public void addGrandTotal(){
		//add nothing to the grand total column
		this.addCell("", false, true);
	}

}
