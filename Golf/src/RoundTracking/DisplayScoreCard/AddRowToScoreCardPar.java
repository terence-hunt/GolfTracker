package RoundTracking.DisplayScoreCard;

import GolfCourseData.GolfCourse;

public class AddRowToScoreCardPar extends AddRowToScoreCardInteger {

	GolfCourse course;
	
	public AddRowToScoreCardPar(GolfCourse course, String rowName ){
		this.course = course;
		this.rowName = rowName;
		this.noOfColumns = course.getNumberOfHoles();
	}
	
	@Override
	public int getValue(int i) {
		return course.getPar(i);
	}

}
