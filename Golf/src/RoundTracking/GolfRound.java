package RoundTracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import GolfCourseData.GolfCourse;

public class GolfRound {
	ArrayList<PlayerScore> playersScores = new ArrayList<PlayerScore>();
	GolfCourse course;
	Date dateOfRound;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public GolfRound(){
		dateOfRound = new Date();
	}
	
	public GolfRound(ArrayList<PlayerScore> playersScores, GolfCourse course){
		dateOfRound = new Date();
		this.playersScores = playersScores;
		this.course = course;
	}
	
	public String getDateOfRound(){
		return dateFormat.format(dateOfRound);
	}
	public PlayerScore getPlayer(int playerNumber){
		return playersScores.get(playerNumber);
	}
	public GolfCourse getGolfCourse(){
		return course;
	}
	public ArrayList<PlayerScore> getPlayersScores(){
		return playersScores;
	}
	public void setPlayersScores(ArrayList<PlayerScore> scores){
		this.playersScores = scores;
	}
	public void setCourse(GolfCourse course){
		this.course = course;
	}
}


