package test.src.Lessons.Kavalevsky.M_10_X0.Model;

import java.awt.Point;

import javax.activity.InvalidActivityException;

import M_10_X0.Model.Exceptions.AlreadyOccupiedException;
import M_10_X0.Model.Exceptions.InvalidPointException;

public class CField {
//	private static final int MAX_COORDINATE=FIELD_SIZE; 
	private static final int MIN_COORDINATE=0;

	private final int fieldSize; 
	
	private final EFigure[][] field;

	public CField(int fieldSize) {
		super();
		this.fieldSize = fieldSize;
		this.field =  new EFigure[fieldSize][fieldSize]; 
	}

	
	public int getSize() {
		return this.fieldSize; 
	}
	
	public void setFigure(final Point newPoint, final EFigure newFigure) 
				 throws InvalidPointException {
		
		if(!this.checkPoint(newPoint)) {
			throw new InvalidPointException(); 
		}
		
		field[newPoint.x][newPoint.y] = newFigure;  
	}
	
	public EFigure getFigure(final Point point) throws InvalidPointException {
		if(!this.checkPoint(point)) {
			throw new InvalidPointException(); 
		}
		return this.field[point.x][point.y]; 
	}

	private boolean checkPoint(final Point newPoint) {
		return (checkCoordinate(newPoint.x, this.field.length) && checkCoordinate(newPoint.y, this.field[newPoint.x].length));
		
	}
	
	private boolean checkCoordinate(final int coordinate, final int maxCoordinat) {
		return (coordinate <  maxCoordinat && coordinate >= CField.MIN_COORDINATE);  
	}
}
