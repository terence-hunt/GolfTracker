package PlayerData.GolfClubs;

public class Club {
	String longName;
	String shortName;
	
	public Club(String longName, String shortName){
		this.longName = longName;
		this.shortName = shortName;
	}
	
	public String getLongName(){
		return longName;
	}
}
