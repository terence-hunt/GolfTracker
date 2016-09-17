package RoundTracking;

public class ScoreForHole {
	int holeNumber;
	int netScore;
	int grossScore;
	String FIR;
	boolean GIR;
	int numberOfPutts;

	
	public ScoreForHole(){
		
	}
	
	public ScoreForHole(int netScore, int numberOfPutts){
		this.netScore = netScore;
		this.numberOfPutts = numberOfPutts;
	}
	
	public ScoreForHole(int holeNumber,int netScore, int numberOfPutts, String FIR){
		this.holeNumber = holeNumber;
		this.netScore = netScore;
		this.numberOfPutts = numberOfPutts;
		this.FIR = FIR;
	}
	
	//this is used for par3
	public void setScore(int holeNumber,int netScore, int numberOfPutts){
		this.holeNumber = holeNumber;
		this.netScore = netScore;
		this.numberOfPutts = numberOfPutts;
	}
	public void setScore(int holeNumber,int netScore, int numberOfPutts, String FIR){
		this.holeNumber = holeNumber;
		this.netScore = netScore;
		this.numberOfPutts = numberOfPutts;
		this.FIR = FIR;
	}
	
	public void setGIR(int holePar){
		if((netScore - numberOfPutts) <= (holePar -2) ){
			GIR = true;
		}
		else GIR=false;
	}
	
	public void calculateNetScore(float playerHandicap, int holeSI){
		int quotant = Math.round(playerHandicap) / 18;
		int remainder = Math.round(playerHandicap) % 18;
		
		grossScore = netScore - quotant;
		
		if(remainder >= holeSI ){
			grossScore -= 1;
		}
	}
	
	public int getGrossScore(){
		return grossScore;
	}
	public int getNetScore(){
		return netScore;
	}
	public int getNumberOfPutts(){
		return numberOfPutts;
	}
	public boolean getGIR(){
		return GIR;
	}
}


