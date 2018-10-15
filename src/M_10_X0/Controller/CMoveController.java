package M_10_X0.Controller;

import java.awt.Point;

import M_10_X0.Model.EFigure;
import M_10_X0.Model.CField;
import M_10_X0.Model.CPlayer;
import M_10_X0.Model.Exceptions.InvalidMoveException;
import M_10_X0.Model.Exceptions.InvalidPointException;
import M_10_X0.Model.Exceptions.AlreadyOccupiedException;;


public class CMoveController {
    public CMoveController() {
	super(); 
    }

    public void applyFigure(final CField gameBoard, final Point toPoint,final EFigure figure) 
	    throws AlreadyOccupiedException,InvalidPointException {
	
	if(gameBoard.getFigure(toPoint) != null) {
	    throw new AlreadyOccupiedException();
	}
	gameBoard.setFigure(toPoint, figure);
    }
}
