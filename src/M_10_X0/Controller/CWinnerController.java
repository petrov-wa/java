package M_10_X0.Controller;

import java.awt.Point;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.InvalidPointException;
import M_10_X0.Model.Exceptions.NoWinnerException;

public class CWinnerController {

    public CWinnerController() {
	super(); 
    }
    
    public EFigure getWinner(final CField gameBoard) {

	
	try {
	    for(int i=0; i<gameBoard.getSize(); i++) {
		if(check(gameBoard, new Point(i, 0), p->new Point(p.x, p.y+1))){
		    return gameBoard.getFigure(new Point(i, 0));
		}
	    }
	    for(int i=0; i<gameBoard.getSize(); i++) {
		if(check(gameBoard, new Point(0, i), p->new Point(p.x+1, p.y))){
		    return gameBoard.getFigure(new Point(0, i));
		}
	    }
	    if(check(gameBoard, new Point(0, 0), p->new Point(p.x + 1, p.y + 1))) {
		return gameBoard.getFigure(new Point(0,0));
	    }
	    if(check(gameBoard, new Point(0, gameBoard.getSize()-1), p->new Point(p.x + 1, p.y - 1))) {
		return gameBoard.getFigure(new Point(0, gameBoard.getSize()-1));
	    }
	} catch(InvalidPointException e){
	    e.printStackTrace();
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

    private boolean check(final CField gameBoard, final Point currentPoint, final IPointChanger pointGenerator) {
	
	final EFigure currentFigure;
	final EFigure nextFigure;
	final Point nextPoint = pointGenerator.next(currentPoint);
	
	try {
	    // пробуем получить фигуру из текущего поля и следующего
	    currentFigure = gameBoard.getFigure(currentPoint); 
//	    if(currentFigure == null) { return false; } // текущее поле не заполнено --
	    nextFigure    = gameBoard.getFigure(nextPoint);
	} catch (final InvalidPointException e) {
	    // если возникло исключение "неверное поле", значит нет пары фигур для сравнения на текущем
	    // шаге, но раз мы дошли до этого шага, значит до этого шага фигуры совпадали, значит 
	    // действительно кто-то победил
	    return true; 
	}
	
	if(currentFigure == null) { return false; } // текущее поле не заполнено -- значит в этом направлении победителей нет 
	if(currentFigure != nextFigure) {return false; } // в текущем поле не такая фигурка как в следующем -- нет 
	                                                 // победитедя в данном направлении

	return this.check(gameBoard, nextPoint, pointGenerator); 
    }
    
    private static interface IPointChanger {
	Point next(final Point current); 
    }
}
