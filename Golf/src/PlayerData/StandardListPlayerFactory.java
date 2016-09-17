package PlayerData;

import java.util.Date;

public class StandardListPlayerFactory extends PlayerFactory{

	public StandardListPlayerFactory(){

	}

	public Player getPlayer(String name){
		switch(name) {
		case "Terence" : this.createTerence();
			break;
		case "Steve" : this.createSteve();
			break;
		default : this.createEmpty();
		}
		return player;
	}

	public void createTerence(){
		player = new Player("Terence Hunt",new Date(611884800),15.0f);
	}
	public void createSteve(){
		player = new Player("Steve Hart",new Date(428544000),28.0f);
	}
	public void createEmpty() {
		player = new Player("Does not exist",new Date(0),0);
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
}
