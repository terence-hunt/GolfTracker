package GolfCourseData;

public class HoleYardage {
	int redTee;
	int blueTee;
	int yellowTee;
	int whiteTee;
	
	public HoleYardage(int red, int blue, int yellow, int white) {
		this.redTee = red;
		this.blueTee = blue;
		this.yellowTee = yellow;
		this.whiteTee = white;
	}
	
	public int getYardage(String teeColour) {
		switch (teeColour) {
		case "red" : return redTee;
		case "blue" : return blueTee;
		case "yellow" : return yellowTee;
		case "white" : return whiteTee;
		default : System.out.println("ERROR - tee " + teeColour + " does not exist");
				  Thread.currentThread().getStackTrace();
				  return 0;
		}
	}
}
