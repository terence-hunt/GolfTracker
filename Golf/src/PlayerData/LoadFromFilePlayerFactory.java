package PlayerData;

import java.io.File;
import java.util.Date;

public class LoadFromFilePlayerFactory extends PlayerFactory {

	public Player create(String fileName){
		File file = new File(fileName);
		//TODO add code to read the file and create the player from the information in the file
		return new Player("Does not exist",new Date(0),0);
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
