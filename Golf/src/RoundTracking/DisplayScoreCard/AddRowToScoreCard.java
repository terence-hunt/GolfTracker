package RoundTracking.DisplayScoreCard;

public abstract class AddRowToScoreCard {
	
	public String htmlString ="";
	protected static final String HTML_BEGIN = "<td style=\"text-align: center;\">"; 
	protected static final String HTML_END = "</td>\n";
	
	public int noOfColumns;
	public String rowName;

	
	public abstract String getRow();
	
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
	
	
	
	

}

