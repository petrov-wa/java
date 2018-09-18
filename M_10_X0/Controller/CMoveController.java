package Lessons.Kavalevsky.M_10_X0.Controller;

import java.awt.Point;

import Lessons.Kavalevsky.M_10_X0.Model.EFigure;
import Lessons.Kavalevsky.M_10_X0.Model.CField;
import Lessons.Kavalevsky.M_10_X0.Model.CPlayer;
import Lessons.Kavalevsky.M_10_X0.Model.Exceptions.InvalidMoveException;
import Lessons.Kavalevsky.M_10_X0.Model.Exceptions.InvalidPointException;
import Lessons.Kavalevsky.M_10_X0.Model.Exceptions.AlreadyOccupiedException;;


public class CMoveController {

	public CMoveController() {
		// TODO Auto-generated constructor stub
	}

	void applyFigure(final CField gameBoard, 
					 final Point toPoint, 
					 final EFigure figure) throws AlreadyOccupiedException,
	    										  InvalidPointException {
		
		if(gameBoard.getFigure(toPoint) != null) {
			throw new AlreadyOccupiedException();
		}
		gameBoard.setFigure(toPoint, figure);
	}
}
