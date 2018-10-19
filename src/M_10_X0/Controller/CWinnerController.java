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
	    // ������� �������� ������ �� �������� ���� � ����������
	    currentFigure = gameBoard.getFigure(currentPoint); 
//	    if(currentFigure == null) { return false; } // ������� ���� �� ��������� --
	    nextFigure    = gameBoard.getFigure(nextPoint);
	} catch (final InvalidPointException e) {
	    // ���� �������� ���������� "�������� ����", ������ ��� ���� ����� ��� ��������� �� �������
	    // ����, �� ��� �� ����� �� ����� ����, ������ �� ����� ���� ������ ���������, ������ 
	    // ������������� ���-�� �������
	    return true; 
	}
	
	if(currentFigure == null) { return false; } // ������� ���� �� ��������� -- ������ � ���� ����������� ����������� ��� 
	if(currentFigure != nextFigure) {return false; } // � ������� ���� �� ����� ������� ��� � ��������� -- ��� 
	                                                 // ���������� � ������ �����������

	return this.check(gameBoard, nextPoint, pointGenerator); 
    }
    
    private static interface IPointChanger {
	Point next(final Point current); 
    }
}
