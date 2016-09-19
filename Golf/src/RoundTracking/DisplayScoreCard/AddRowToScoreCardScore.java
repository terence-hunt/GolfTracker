package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;
import RoundTracking.PlayerScore;

public abstract class AddRowToScoreCardScore extends AddRowToScoreCard {

	GolfCourse course;
	PlayerScore playerScore;
	
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
	
	public abstract int getValue(int i);
	
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
