package M_10_X0.Model;

public class CGame {

	private final CPlayer[] players; 
	private final CField field; 
	private final String name; 
	
	public CGame(final CPlayer[] newPlayers, final CField newField, final String newName) {
		// TODO Auto-generated constructor stub
		
		this.players = newPlayers; 
		this.field = newField; 
		this.name = newName; 
	}

	
	CPlayer[] getPlayers() {
		return this.players; 
	}
	
	CField getField() {
		return this.field; 
	}
	
	String getName() {
		return this.name; 
	}
}
