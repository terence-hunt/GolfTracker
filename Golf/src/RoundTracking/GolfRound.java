package RoundTracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import GolfCourseData.GolfCourse;
import PlayerData.Player;

public class GolfRound {
	ArrayList<PlayerScore> playersScores = new ArrayList<PlayerScore>();
	GolfCourse course;
	Date dateOfRound;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public GolfRound(ArrayList<PlayerScore> playersScores, GolfCourse course){
		dateOfRound = new Date();
		this.playersScores = playersScores;
		this.course = course;
	}
	
	public String getCourseName(){
		return course.getCourseName();
	}
	public String getDateOfRound(){
		return dateFormat.format(dateOfRound);
	}
	public int getNumberOfHoles(){
		return course.getNumberOfHoles();
	}
	public int getParForHole(int holeNumber){
		return course.getPar(holeNumber);
	}
	public int getStrokeIndexForHole(int holeNumber){
		return course.getStrokeIndexForHole(holeNumber);
	}
	public String getPlayerName(int playerNumber){
		return playersScores.get(playerNumber).getPlayerName();
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
}


