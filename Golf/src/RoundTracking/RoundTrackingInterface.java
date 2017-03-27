package RoundTracking;

import java.io.File;
import RoundTracking.DisplayScoreCard.HTMLPrintScoreCard;

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


