package M_10_X0.Model;

public class CGame {

	private final CPlayer[] players; 
	private final CField field; 
	private final String name; 
	
	public CGame(final CPlayer[] newPlayers, final CField newField, final String newName) {
		this.players = newPlayers; 
		this.field = newField; 
		this.name = newName; 
	}

	
	public CPlayer[] getPlayers() {
		return this.players; 
	}
	
	public CField getField() {
		return this.field; 
	}
	
	public String getName() {
		return this.name; 
	}
}
