package GolfCourseData;

import java.util.ArrayList;

public class stAndrewsCourseFactory extends GolfCourseFactory {
	//The old course at st Andrews
	
	public ArrayList<Hole> createGolfCourse(){ 
		courseName="St Andrews";
		
		ArrayList<Hole> course = new ArrayList<Hole>();
		
		course.add(new Hole(new HoleYardage(339,0,355,376),1,4,10));
		course.add(new Hole(new HoleYardage(375,0,395,411),2,4,6));
		course.add(new Hole(new HoleYardage(321,0,337,370),3,4,16));
		course.add(new Hole(new HoleYardage(401,0,411,419),4,4,8));
		course.add(new Hole(new HoleYardage(454,0,514,514),5,5,2));
		course.add(new Hole(new HoleYardage(325,0,360,374),6,4,12));
		course.add(new Hole(new HoleYardage(335,0,349,359),7,4,4));
		course.add(new Hole(new HoleYardage(145,0,154,166),8,3,14));
		course.add(new Hole(new HoleYardage(261,0,289,347),9,4,18));
		course.add(new Hole(new HoleYardage(296,0,311,340),10,4,15));
		course.add(new Hole(new HoleYardage(150,0,164,174),11,3,7));
		course.add(new Hole(new HoleYardage(304,0,304,316),12,4,3));
		course.add(new Hole(new HoleYardage(377,0,388,418),13,4,11));
		course.add(new Hole(new HoleYardage(487,0,523,530),14,5,1));
		course.add(new Hole(new HoleYardage(369,0,391,414),15,4,9));
		course.add(new Hole(new HoleYardage(325,0,345,381),16,4,13));
		course.add(new Hole(new HoleYardage(426,0,436,455),17,4,5));
		course.add(new Hole(new HoleYardage(342,0,361,357),18,4,17));
		return course;
	}

	public String getCourseName() {
		return courseName;
	}
}
