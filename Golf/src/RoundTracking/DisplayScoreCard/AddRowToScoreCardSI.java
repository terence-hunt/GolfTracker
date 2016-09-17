package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;

public class AddRowToScoreCardSI extends AddRowToScoreCard {

	GolfCourse course;

	public AddRowToScoreCardSI(GolfCourse course, String rowName ){
		this.course = course;
		this.rowName = rowName;
		this.noOfColumns = course.getNumberOfHoles();
	}

	@Override
	public int getValue(int i) {
		return course.getHole(i).getSI();
	}

	@Override
	public void addTotal(int i){
		this.addCell("", false, false);
	}

	@Override
	public void addGrandTotal(){
		this.addCell("",false, true);
	}
}
