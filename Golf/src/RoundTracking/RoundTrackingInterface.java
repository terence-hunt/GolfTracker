package RoundTracking;

import java.io.File;
import java.util.ArrayList;

import GolfCourseData.GolfCourse;
import PlayerData.Player;
import RoundTracking.DisplayScoreCard.HTMLPrintScoreCard;
import RoundTracking.DisplayScoreCard.PrintScoreCard;

/**
 * @author tahun
 *
 */
public class RoundTrackingInterface {
	GolfRound round;
	
	public RoundTrackingInterface(){
		
	}
	

	public void scoreRound(RoundFactory factory){
		round = factory.getRound();
		this.getScoreCard();
	}
	
	//file contains score and name of golf course
	public void scoreRound(File file){
		
	}
	
	
	public void saveRound(){
		
	}
	
	public void loadRound(){
		
	}
	
	public void getScoreCard(){
		 PrintScoreCard print = new HTMLPrintScoreCard();
		 print.print(round);
	}
}


