package PlayerData;

import java.util.ArrayList;
import java.util.Date;

import PlayerData.GolfClubs.Club;
import PlayerData.GolfClubs.ClubsFactory;

public class Player {
	String name;
	Date DOB;
	float handicap;
	ArrayList<Club> clubs;
	
	public Player(String name, Date DOB, float handicap, ClubsFactory factory){
		this.name = name;
		this.DOB = DOB;
		this.handicap = handicap;
		clubs = new ArrayList<Club>();
		factory.getSetOfClubs();
	}
	
	public String getPlayerName(){
		return name;
	}
	public float getHandicap(){
		return handicap;
	}
}
