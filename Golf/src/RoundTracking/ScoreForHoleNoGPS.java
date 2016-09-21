package RoundTracking;

import Data.ConfigurationSettings.FIREnum;

public class ScoreForHoleNoGPS extends ScoreForHole {

	int numberOfPutts;
	int grossScore;
	
	public ScoreForHoleNoGPS(){
		
	}
	
	public ScoreForHoleNoGPS(int holeNumber,int grossScore, int numberOfPutts, FIREnum FIR){
		this.holeNumber = holeNumber;
		this.grossScore = grossScore;
		this.numberOfPutts = numberOfPutts;
		this.FIR = FIR;
	}
	
	public void setScore(int holeNumber,int grossScore, int numberOfPutts){
		setScore(holeNumber, grossScore, numberOfPutts, FIREnum.NR);
	}
	public void setScore(int holeNumber,int grossScore, int numberOfPutts, FIREnum FIR){
		this.holeNumber = holeNumber;
		this.grossScore = grossScore;
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
		
		netScore = grossScore - quotant;
		
		if(remainder >= holeSI ){
			netScore -= 1;
		}
	}

	@Override
	public boolean getGIR() {
		return GIR;
	}

	@Override
	public int getGrossScore() {
		return grossScore;
	}

	@Override
	public int getNetScore() {
		return netScore;
	}

	@Override
	public int getNumberOfPutts() {
		return numberOfPutts;
	}

	public void setGrossScore(float playerHandicap, int holeSI) {
		int quotant = Math.round(playerHandicap) / 18;
		int remainder = Math.round(playerHandicap) % 18;
		
		netScore = grossScore - quotant;
		
		if(remainder >= holeSI ){
			netScore -= 1;
		}
	}
}
