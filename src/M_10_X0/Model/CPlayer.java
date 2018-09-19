package M_10_X0.Model;

public class CPlayer {
	
	private final String name; 
	private final EFigure figure; 
	
	public String getName() {
		return this.name; 
	}
	
	public EFigure getFigure() {
		return this.figure;
	}
	
	public CPlayer(final String playerName, final EFigure playerFigure ) {
		// TODO Auto-generated constructor stub
		this.name = playerName; 
		this.figure = playerFigure; 
	}

}
