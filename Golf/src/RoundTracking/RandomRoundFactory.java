package RoundTracking;

import java.util.ArrayList;
import java.util.Random;

import Data.ConfigurationSettings.FIREnum;
import GolfCourseData.GolfCourse;
import PlayerData.Player;

public class RandomRoundFactory implements RoundFactory
{
	GolfCourse course;
	ArrayList<Player> players = new ArrayList<Player>();
	String tee; //the colour of the tee that the players are useing.
	//TODO the players can play of different tees, women for example. need to make this a player attribute rather than a round attribute
	
	public RandomRoundFactory(GolfCourse course, ArrayList<Player> players, String tee){
		this.course = course;
		this.players = players;
		this.tee = tee;
	}

	@Override
	public GolfRound getRound() {
		Random rand = new Random();
		ArrayList<PlayerScore> playersScores = new ArrayList<PlayerScore>();
		
		for(Player player : players){
			ArrayList<ScoreForHole> totalScore = new ArrayList<ScoreForHole>();
			
			for(int hole=1 ; hole<=course.getNumberOfHoles() ; hole++){

				ScoreForHole scoreForHole = new ScoreForHole();
				int randint = rand.nextInt(6)+2;

				if(course.getPar(hole) == 3){

					scoreForHole.setScore(hole, randint, rand.nextInt(randint-1));
				}
				else{
					FIREnum FIR = FIREnum.NR;
					int temp = rand.nextInt(4);
					if(temp == 0){
						FIR = FIREnum.L;
					}
					if (temp == 1 || temp == 3){
						FIR = FIREnum.S;
					}
					if (temp == 2){
						FIR = FIREnum.R;
					}
					scoreForHole.setScore(hole, randint, rand.nextInt(randint),FIR);
				}
				scoreForHole.calculateGrossScore(player.getHandicap(), course.getStrokeIndexForHole(hole));
				scoreForHole.setGIR(course.getPar(hole));
				totalScore.add(scoreForHole);
			}
			
			PlayerScore playerScore = new PlayerScore(player,totalScore);
			playersScores.add(playerScore);
		}

		GolfRound round = new GolfRound(playersScores,course);

		return round;
	}
	
}
