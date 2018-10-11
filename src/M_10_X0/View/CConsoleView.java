package M_10_X0.View;

import java.awt.Point;

import M_10_X0.Model.CField;
import M_10_X0.Model.CGame;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.InvalidPointException;

public class CConsoleView {
	
	public void show(final CGame game) {
		final CField gameBoard = game.getField();
		
		System.out.format("Game name: %s\n",  game.getName());
		
		for(int row=0; row<gameBoard.getSize(); row++) {
		    	if(row!=0) {
		    	    printSepartor(gameBoard); 
		    	}
			printLine(gameBoard, row);
		}
	}


	public void move(final CGame game) { 
		
	}

	private void printLine(final CField gameBoard, final int row){
		System.out.print("|");
		for(int column=0; column<gameBoard.getSize(); column++) {
			final EFigure figure ;
			try {
				figure = gameBoard.getFigure(new Point(row, column));
			} catch(InvalidPointException e) {
				e.printStackTrace();
				throw new RuntimeException(e); 
			}
			System.out.print(figure != null? figure : " ");
		}
		System.out.println("|");
	}
	
	private void printSepartor(final CField gameBoard) {
	    for(int i=0; i<gameBoard.getSize()+2; i++) {
		System.out.print("-");
	    }
	    System.out.println();
	}
}
