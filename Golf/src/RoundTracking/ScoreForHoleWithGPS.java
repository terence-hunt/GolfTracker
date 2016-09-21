package RoundTracking;

import java.util.ArrayList;

import PlayerData.GolfClubs.Club;

public class ScoreForHoleWithGPS extends ScoreForHole {

	ArrayList<Shot> shots;
	
	public ScoreForHoleWithGPS(){
		shots = new ArrayList<Shot>();
	}
	
	public void addShot(Club club, String GPSCoordinate){
		shots.add(new Shot(club,GPSCoordinate));
	}

	@Override
	public int getGrossScore() {
		return shots.size();
	}


	@Override
	public int getNumberOfPutts() {
		int putts = 0;
		for (Shot shot : shots){
			if(shot.getClub().getLongName().equals("Putter")){
				putts++;
			}
		}
		return putts;
	}
	
}
