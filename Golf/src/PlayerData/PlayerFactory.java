package PlayerData;

import java.util.ArrayList;

public abstract class PlayerFactory {

	Player player;
	ArrayList<Player> players;
	
	public abstract Player getPlayer();
	public abstract Player getPlayer(String name);
	public ArrayList<Player> getPlayers(){
		return players;
	}
}

