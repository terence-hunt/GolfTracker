package GolfCourseData;

import java.io.File;
import java.util.ArrayList;

public abstract class GolfCourseFactory {
	String courseName;
	ArrayList<Hole> course;
	File file;
	
	public abstract ArrayList<Hole> createGolfCourse();

	
	public String getCourseName(){
		return  courseName;
	}
}
