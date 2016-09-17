package PlayerData;

import java.util.Date;

public class Player {
	String name;
	Date DOB;
	float handicap;
	
	public Player(String name, Date DOB, float handicap){
		this.name = name;
		this.DOB = DOB;
		this.handicap = handicap;
		
	}
	public String getPlayerName(){
		return name;
	}
	public float getHandicap(){
		return handicap;
	}
}
