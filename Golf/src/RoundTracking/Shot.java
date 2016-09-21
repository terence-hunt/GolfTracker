package RoundTracking;

import PlayerData.GolfClubs.Club;

public class Shot {
	Club club;
	String GPSCoordinate;

	
	public Shot(Club club, String GPSCoordinate){
		this.club = club;
		this.GPSCoordinate = GPSCoordinate;
	}
	
	public Club getClub(){
		return club;
	}
}
