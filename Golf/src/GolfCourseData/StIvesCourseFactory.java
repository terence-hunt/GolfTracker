package GolfCourseData;

import java.util.ArrayList;

public class StIvesCourseFactory extends GolfCourseFactory {

	public ArrayList<Hole> createGolfCourse(){ 
		courseName = "St Ives (Hunts) Golf Club";
		ArrayList<Hole> course = new ArrayList<Hole>();
		course.add(new Hole(new HoleYardage(200,300,400,500),1,4,1));
		course.add(new Hole(new HoleYardage(200,300,400,500),2,4,2));
		course.add(new Hole(new HoleYardage(200,300,400,500),3,5,3));
		course.add(new Hole(new HoleYardage(200,300,400,500),4,4,4));
		course.add(new Hole(new HoleYardage(200,300,400,500),5,4,5));
		course.add(new Hole(new HoleYardage(200,300,400,500),6,5,6));
		course.add(new Hole(new HoleYardage(200,300,400,500),7,5,7));
		course.add(new Hole(new HoleYardage(200,300,400,500),8,4,8));
		course.add(new Hole(new HoleYardage(200,300,400,500),9,4,9));
		course.add(new Hole(new HoleYardage(200,300,400,500),10,4,10));
		course.add(new Hole(new HoleYardage(200,300,400,500),11,5,11));
		course.add(new Hole(new HoleYardage(200,300,400,500),12,4,12));
		course.add(new Hole(new HoleYardage(200,300,400,500),13,4,13));
		course.add(new Hole(new HoleYardage(200,300,400,500),14,4,14));
		course.add(new Hole(new HoleYardage(200,300,400,500),15,5,15));
		course.add(new Hole(new HoleYardage(200,300,400,500),16,4,16));
		course.add(new Hole(new HoleYardage(200,300,400,500),17,4,17));
		course.add(new Hole(new HoleYardage(200,300,400,500),18,5,18));
		return course;
	}

	public String getCourseName() {
		return courseName;
	}
}

