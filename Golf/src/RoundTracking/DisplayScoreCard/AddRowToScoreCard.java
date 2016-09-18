package RoundTracking.DisplayScoreCard;

public abstract class AddRowToScoreCard {
	
	public String htmlString ="";
	protected static final String HTML_BEGIN = "<td style=\"text-align: center;\">"; 
	protected static final String HTML_END = "</td>\n";
	
	public int noOfColumns;
	public String rowName;

	public abstract int getValue(int i);
	
	public void addCell(String string, boolean startOfRow, boolean endOfRow){
		if(startOfRow){
			htmlString += "<tr>\n";
		}
		htmlString += HTML_BEGIN + string + HTML_END;

		if(endOfRow){
			htmlString += "</tr>\n";
		}
	}
	public void addCell(int string, boolean startOfRow, boolean endOfRow){
		addCell(Integer.toString(string),startOfRow,endOfRow);
	}
	
	
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

