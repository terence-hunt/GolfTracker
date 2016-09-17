package RoundTracking;

import java.util.ArrayList;
import java.util.Scanner;

import Data.ScannerSingleton;
import GolfCourseData.*;
import PlayerData.Player;

public class ManualInputRoundFactory implements RoundFactory {

	GolfRound round;
	
	GolfCourse course;
	ArrayList<Player> players = new ArrayList<Player>();
	String tee; //the colour of the tee that the players are useing.
	//TODO the players can play of different tees, women for example. need to make this a player attribute rather than a round attribute
	
	public ManualInputRoundFactory(GolfCourse course, ArrayList<Player> players, String tee){
		this.course = course;
		this.players = players;
		this.tee = tee;
	}


	@Override
	public GolfRound getRound() {
		// TODO Auto-generated method stub
		return null;
	}
}
