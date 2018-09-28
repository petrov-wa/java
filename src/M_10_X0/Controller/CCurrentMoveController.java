package M_10_X0.Controller;

import java.awt.Point;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.InvalidPointException;

public class CCurrentMoveController {

	public CCurrentMoveController() {
		// TODO Auto-generated constructor stub
	}

	EFigure currentMove(CField gameBoard) throws InvalidPointException {
/*		int cntX = 0;
		int cnt0 = 0;
*/
		int cnt = 0;  
		
		for(int i=0; i<gameBoard.getSize(); i++){
			for(int j=0; j<gameBoard.getSize(); j++) {
/*				switch(gameBoard.getFigure(new Point(i,j))) {
					case X: cntX++; break;  
					case O: cnt0++; break; 
				}
*/
				if(gameBoard.getFigure(new Point(i,j)) != null) { cnt++; }
			}
		}	
		if(cnt == gameBoard.getSize()*gameBoard.getSize()) { return null; }
		if(cnt % 2 == 1) { return EFigure.O; }
		else { return EFigure.X; }
	}
}
