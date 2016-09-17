package GolfCourseData;

import java.awt.Image;

public class Hole {
	HoleYardage yardages;
	int holeNumber;
	int par;
	Image holeMap;
	String holeDiscription;
	String holeName;
	int strokeIndex;
	
	public Hole() {
		
	}
	
	public Hole(int yardage, int holeNumber){
		this.holeNumber = holeNumber;
	}
	public Hole(HoleYardage yardages, int holeNumber, int par){
		this.yardages = yardages;
		this.holeNumber = holeNumber;
		this.par = par;
	}
	public Hole(HoleYardage yardages, int holeNumber, int par,int strokeIndex){
		this.yardages = yardages;
		this.holeNumber = holeNumber;
		this.par = par;
		this.strokeIndex = strokeIndex;
	}
	public HoleYardage getHoleYardages(){
		return yardages;
	}

	public int getHoleNumber(){
		return holeNumber;
	}
	public Image getHoleMap(){
		return holeMap;
	}
	public int getPar(){
		return par;
	}
	public int getSI(){
		return strokeIndex;
	}
	

	
}
