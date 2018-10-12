package M_10_X0.Controller;

import java.awt.Point;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.InvalidPointException;

public class CCurrentMoveController {
    public CCurrentMoveController() {
	super(); 
    }
    
    public EFigure currentMove(CField gameBoard){
	int cnt = 0;

	for(int i=0; i<gameBoard.getSize(); i++){
	    for(int j=0; j<gameBoard.getSize(); j++) {
/*		switch(gameBoard.getFigure(new Point(i,j))) {
		case X: cntX++; break;
		case O: cnt0++; break;
		}
*/
		try {
		    if(gameBoard.getFigure(new Point(i,j)) != null) { cnt++; }
		}catch(InvalidPointException e) {
		    /*
		     * if get exception via simplify walking on game board -- then game mast fall   
		     * */
		    throw new RuntimeException(e); 
		}
	    }
	}
	if(cnt == gameBoard.getSize()*gameBoard.getSize()) { return null; }
	if(cnt % 2 == 1) { return EFigure.O; }
	else { return EFigure.X; }
    }
}
