package RoundTracking.DisplayScoreCard;

import RoundTracking.PlayerScore;

public abstract class AddRowToScoreCardString extends AddRowToScoreCard {

	PlayerScore playerScore;
	
	public abstract String getValue(int i);	
	public abstract void addTotal(int i);
	public abstract void addGrandTotal();
	
	public String getRow() {
		this.addCell(rowName, true, false);
		
		for(int i=1 ; i<=noOfColumns ; i++){
			this.addCell(getValue(i), false, false);
			if(i%9 == 0) {
				addTotal(i);
			}
		}
		addGrandTotal();
		return htmlString;
	}
}
