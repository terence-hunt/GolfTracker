import java.util.ArrayList;
import GolfCourseData.*;
import PlayerData.Player;
import PlayerData.*;
import PlayerData.StandardListPlayerFactory;
import RoundTracking.*;



/**
 * @author tahun
 *  Welcolme to the Golf course score tracker.
 *
 */
public class GolfCourseLauncher {
	GolfCourse course;

	public static void main(String[] args) {
		GolfCourseLauncher launcher = new GolfCourseLauncher();
		launcher.go();
	}

	public void go(){
		System.out.println("Welcome to the golf statistics tracker, what course would you like to play?");
		//Scanner in = ScannerSingleton.getScanner();
		//String value = in.nextLine();
		
		String value = "st Andrews";
		
		
		switch(value) {
		case "st Andrews" : course = new GolfCourse(new stAndrewsCourseFactory());
		break;
		case "st Ives" : course = new GolfCourse(new StIvesCourseFactory());
		break;
		default : System.out.println("I am sorry, that course does not exist, please try again");
		}
		
		System.out.println("Good choice, whats your name?");
		
		PlayerFactory playerFactory = new StandardListPlayerFactory();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(playerFactory.getPlayer("Terence"));
		//players.add(playerFactory.getPlayer("Steve"));
				
		
		RoundTrackingInterface round = new RoundTrackingInterface();
		// could also create factories that load from db or files
		//RoundFactory factory = new ManualInputRoundFactory(course,players,"Blue");
		RoundFactory factory = new RandomRoundFactory(course,players,"Blue");
		round.scoreRound(factory);


		//GolfCourse courseStAndrews = new GolfCourse(new stAndrewsCourseFactory());



		/*System.out.println("Hole 3 is a " + courseStAndrews.getHole(3).getHoleYardages().getYardage("yellow") 
		+ " yard par " + courseStAndrews.getPar(3));

		System.out.println("Hole 3 is a " + courseStAndrews.getHole(3).getHoleYardages().getYardage("blue")
		+ " yards from the blue tee par " + courseStAndrews.getHole(3).getPar());

		System.out.println("This is an " + courseStAndrews.getNumberOfHoles() + " hole golf course.");

		System.out.println("The total yardage is " + courseStAndrews.getTotalYardage("white") + " The total par is " + courseStAndrews.getTotalPar());
		System.out.println("St Andrews is much longer at " + courseStAndrews.getTotalYardage("white") + " yards");*/
	}
}
