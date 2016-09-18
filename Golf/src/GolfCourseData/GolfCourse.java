package GolfCourseData;

import java.util.ArrayList;

public class GolfCourse {

	ArrayList<Hole> course = new ArrayList<Hole>();
	String courseName;
	
	public GolfCourse(GolfCourseFactory factory){
		course = factory.createGolfCourse();
		courseName = factory.getCourseName();
	}
	
	public int getTotalYardage(String teeColour){
		int total = 0;
		for(Hole hole : course) {
			total += hole.getHoleYardages().getYardage(teeColour);
		}
		return total;
	}
	
	public int getTotalPar(){
		int total = 0;
		for(Hole hole : course) {
			total += hole.getPar();
		}
		return total;
	}
	
	public Hole getHole(int holeNumber){
		return course.get(holeNumber-1);
	}
	
	public int getPar(int holeNumber) {
		return course.get(holeNumber-1).getPar();
	}
	
	public int getNumberOfHoles(){
		return course.size();
	}	
	
	public String getCourseName(){
		return courseName;
	}
	public int getStrokeIndexForHole(int holeNumber){
		return course.get(holeNumber-1).getSI();
	}
	public ArrayList<Hole> getCourse(){
		return course;
	}
}


