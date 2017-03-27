package PlayerData.GolfClubs;

import java.util.ArrayList;

public class StandardSetClubsFactory extends ClubsFactory {

	String set;
	
	public StandardSetClubsFactory(String set){
		this.set = set;
	}
	
	@Override
	public ArrayList<Club> getSetOfClubs() {
		switch(set.toLowerCase()){
		case ("standard") : return this.standardSet();
		default : return standardSet();
		}
	}
	
	public ArrayList<Club> standardSet(){
		ArrayList<Club> clubs = new ArrayList<Club>();
		clubs.add(new Club("Driver","D"));
		clubs.add(new Club("3 Wood","3W"));
		clubs.add(new Club("5 Wood","5W"));
		clubs.add(new Club("3 Hybrid","3H"));
		clubs.add(new Club("4 Hybrid","4H"));
		clubs.add(new Club("3 Iron","3I"));
		clubs.add(new Club("4 Iron","4I"));
		clubs.add(new Club("5 Iron","5I"));
		clubs.add(new Club("6 Iron","6I"));
		clubs.add(new Club("7 Iron","7I"));
		clubs.add(new Club("8 Iron","8I"));
		clubs.add(new Club("9 Iron","9I"));
		clubs.add(new Club("Pitching Wedge","PW"));
		clubs.add(new Club("SandWedge","SW"));
		clubs.add(new Club("Putter","P"));
		return clubs;
	}

}
