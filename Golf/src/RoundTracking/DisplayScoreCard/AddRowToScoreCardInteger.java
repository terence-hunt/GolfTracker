package RoundTracking.DisplayScoreCard;

public abstract class AddRowToScoreCardInteger extends AddRowToScoreCard {
	
	public abstract int getValue(int i);

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
	
	public void addTotal(int i){
		int total = 0;
		for(int hole=i ; hole > i-9 ; hole--){
			total += this.getValue(hole);
		}
		this.addCell(total,false,false);
	}
	
	public void addGrandTotal(){
		int grandTotal = 0;
		for(int hole =1 ; hole<=noOfColumns ; hole++){
			grandTotal += this.getValue(hole);
		}
		this.addCell(grandTotal,false,true);
	}
}
