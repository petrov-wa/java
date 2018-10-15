package M_10_X0;

import M_10_X0.Model.CField;
import M_10_X0.Model.CGame;
import M_10_X0.Model.CPlayer;
import M_10_X0.Model.EFigure;
import M_10_X0.View.CConsoleView;

public class X0cli {

    public static void main(String[] args) {
	final String name1 = "Slava";
	final String name2 = "Ilya";
	
	final CPlayer[] players = new CPlayer[2];
	players[0] = new CPlayer(name1, EFigure.X);
	players[1] = new CPlayer(name2, EFigure.O); 

	final CGame gameX0 = new CGame(players, new CField(3), "X0"); 
	
	final CConsoleView consoleView = new CConsoleView();
	
	consoleView.show(gameX0);
	while(consoleView.move(gameX0)) {
	    consoleView.show(gameX0);
	}
    }
}
