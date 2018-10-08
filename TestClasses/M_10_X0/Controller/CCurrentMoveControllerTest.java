package M_10_X0.Controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;

public class CCurrentMoveControllerTest {

	@Test
	public void testCurrentMoveWhenNextIs0() throws Exception{
		final CCurrentMoveController currentMoveController = new CCurrentMoveController();
		
		for(int i=0; i<3; i++) {
			final CField gameBoard = new CField(3); 
			gameBoard.setFigure(new Point(i,0), EFigure.X);
			gameBoard.setFigure(new Point(i,1), EFigure.O);
			gameBoard.setFigure(new Point(i,2), EFigure.X);
			assertEquals(EFigure.O, currentMoveController.currentMove(gameBoard));
		}
	}
	
	@Test
	public void testCurrentMoveWhenNextIsX() throws Exception{
		final CCurrentMoveController currentMoveController = new CCurrentMoveController();
		
		for(int i=0; i<3; i++) {
			final CField gameBoard = new CField(3); 
			gameBoard.setFigure(new Point(i,0), EFigure.X);
			gameBoard.setFigure(new Point(i,1), EFigure.O);
			assertEquals(EFigure.X, currentMoveController.currentMove(gameBoard));
		}
	}
	
	@Test
	public void testCurrentMoveWhenNextIsNull() throws Exception{
		final CCurrentMoveController currentMoveController = new CCurrentMoveController();
		boolean flag=true; 
		final CField gameBoard = new CField(3); 
		
		for(int i=0; i<gameBoard.getSize(); i++) {
			for(int j=0; j<gameBoard.getSize(); j++) {
				if(flag) {
					gameBoard.setFigure(new Point(i,j), EFigure.X);
				} else {
					gameBoard.setFigure(new Point(i,j), EFigure.O);
				}
				flag = !flag; 
			}
		}
		assertNull(currentMoveController.currentMove(gameBoard));
	}
}
