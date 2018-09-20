package M_10_X0.Controller;

import java.awt.Point;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.InvalidPointException;
import M_10_X0.Model.Exceptions.NoWinnerException;

public class CWinnerController {

	public CWinnerController() {
		// TODO Auto-generated constructor stub
	}

	public EFigure getWinner(final CField gameBoard) throws NoWinnerException {

		for(int i=0; i < gameBoard.getSize(); i++) {
			if(this.check(gameBoard, new Point(i,0), 
						new IPointChanger() {
							@Override 
							public Point next(Point p) {
								return new Point(p.x, p.y+1); 
							}
						}
					)) {
				try {
					return gameBoard.getFigure(new Point(i,0));
				} catch(InvalidPointException e) {
					
				}
			}
		}
		return null;
	}
/*	
	private boolean check(final CField gameBoard, final Point p1, final Point p2, final Point p3) {
		try {
			if( gameBoard.getFigure(p1) == gameBoard.getFigure(p2) && 
				gameBoard.getFigure(p1) == gameBoard.getFigure(p3) && 
				gameBoard.getFigure(p1) != null) {
					return true ;
			}
		} catch(InvalidPointException e) {
			e.printStackTrace();
		}
		return false; 
	}
*/
	private boolean check(final CField gameBoard, final Point startPoint, final IPointChanger pointChanger) {
		Point p2 = pointChanger.next(startPoint);
		Point p3 = pointChanger.next(p2);

		try {
			if( gameBoard.getFigure(startPoint) == gameBoard.getFigure(p2) && 
				gameBoard.getFigure(startPoint) == gameBoard.getFigure(p3) && 
				gameBoard.getFigure(startPoint) != null) {
					return true ;
			}
		} catch(InvalidPointException e) {
			e.printStackTrace();
		}

		return false; 
	}

	
	private static interface IPointChanger {
		Point next(final Point current); 
	}
}
