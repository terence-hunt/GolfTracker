package GolfCourseData;

import java.io.File;
import java.util.ArrayList;

public class FileGolfCourseFactory extends GolfCourseFactory {

	File file;

	public void createGolfCourse(File file) {
		this.file = file;
		this.createGolfCourse();
	}

	@Override
	public ArrayList<Hole> createGolfCourse() {
		// TODO Auto-generated method stub
		return null;
	}
}
