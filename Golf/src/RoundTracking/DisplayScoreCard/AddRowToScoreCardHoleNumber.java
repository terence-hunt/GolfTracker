package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;

public class AddRowToScoreCardHoleNumber extends AddRowToScoreCard {

	GolfCourse course;
	
	public AddRowToScoreCardHoleNumber(GolfCourse course,String rowName){
		this.course = course;
		this.rowName = rowName;
		this.noOfColumns = course.getNumberOfHoles();
	}
	
	@Override
	public int getValue(int i) {
		return course.getHole(i).getHoleNumber();
	}
	
	@Override
	public void addTotal(int i){
		if(i == 9){
			this.addCell("OUT", false, false);
		}
		else if(i==18){
			this.addCell("IN", false, false);
		}
		else{
			this.addCell("previous",false, false);
		}
	}
	
	@Override
	public void addGrandTotal(){
		this.addCell("TOT",false, true);
	}
	
}
