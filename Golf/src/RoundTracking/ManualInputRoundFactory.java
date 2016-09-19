package RoundTracking;

import java.util.ArrayList;
import java.util.Scanner;

import Data.ConfigurationSettings.FIREnum;
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
		round = new GolfRound();
		round.setCourse(course);
		Scanner in = ScannerSingleton.getScanner();
		ArrayList<PlayerScore> playersScores = new ArrayList<PlayerScore>();

		for(Player player : players){
			PlayerScore playerScore = new PlayerScore(player);
			playersScores.add(playerScore);
		}

		for(int hole=1 ; hole<= course.getNumberOfHoles() ; hole++){
			for(PlayerScore playerScore : playersScores ){

				boolean validInput = false;

				while(!validInput){

					try{
						ScoreForHole scoreForHole = new ScoreForHole();
						
						if(course.getPar(hole) == 3){
							System.out.println("Player " + playerScore.getPlayer().getPlayerName() + " hole: " + hole 
									+ ". Please enter Score, number of putts");
							
							scoreForHole.setScore(hole, in.nextInt(),in.nextInt());
						}
						else {
							System.out.println("Player " + playerScore.getPlayer().getPlayerName() + " hole: " + hole 
								+ ". Please enter Score, number of putts, FIR(true/false)");
							
							int score = in.nextInt();
							int putts = in.nextInt();
							String FIR = in.next();
							
							if(FIR.toLowerCase().startsWith("l")){
								scoreForHole.setScore(hole, score,putts,FIREnum.L);
							}
							else if(FIR.toLowerCase().startsWith("r")){
								scoreForHole.setScore(hole, score,putts,FIREnum.R);
							}
							else if(FIR.toLowerCase().startsWith("s")){
								scoreForHole.setScore(hole, score,putts,FIREnum.S);
							}
							else{
								throw new Exception("Invalid FIR direction");
							}
						}
						playerScore.addScoreForHole(hole, scoreForHole);
						scoreForHole.calculateGrossScore(playerScore.getPlayer().getHandicap(), course.getStrokeIndexForHole(hole));
						scoreForHole.setGIR(course.getPar(hole));
						
						validInput = true;
					}
					catch (Exception ex){
						System.out.println("ERR invalid input");
						in.next(); //need this line so that it does not read the error as input.
						//ex.printStackTrace();
					}
					finally{

					}
				}
				round.setPlayersScores(playersScores);
			}
		}
		return round;
	}
}
