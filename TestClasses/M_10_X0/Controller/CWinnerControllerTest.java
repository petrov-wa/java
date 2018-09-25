package M_10_X0.Controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import M_10_X0.Model.CField;
import M_10_X0.Model.EFigure;

public class CWinnerControllerTest {


	@Test
	public void testGetWinnerWhenWinnerRow() throws Exception {
		final CWinnerController winnerController = new CWinnerController(); 
		final int boardSize = 3;
		
		for(int i = 0; i<boardSize; i++) {
			final CField gameBoard = new CField(boardSize);

			for(int j=0; j<boardSize; j++) {
				gameBoard.setFigure(new Point(i,j), EFigure.X);
			}
			assertEquals(EFigure.X, winnerController.getWinner(gameBoard)); 
		}
	}

	@Test
	public void testGetWinnerWhenNOWinnerRow() throws Exception {
		final CWinnerController winnerController = new CWinnerController(); 
		final int boardSize = 3;
		
		for(int i = 0; i<boardSize; i++) {
			final CField gameBoard = new CField(boardSize);

			for(int j=0; j<boardSize-1; j++) {
				gameBoard.setFigure(new Point(i,j), EFigure.X);
			}
			gameBoard.setFigure(new Point(i,boardSize-1), EFigure.O);
			assertNull(winnerController.getWinner(gameBoard)); 
		}
	}
	


	@Test
	public void testGetWinnerWhenWinnerColumn() throws Exception {
		final CWinnerController winnerController = new CWinnerController(); 
		final int boardSize = 3;
		
		for(int i = 0; i<boardSize; i++) {
			final CField gameBoard = new CField(boardSize);

			for(int j=0; j<boardSize; j++) {
				gameBoard.setFigure(new Point(j,i), EFigure.O);
			}
			assertEquals(EFigure.O, winnerController.getWinner(gameBoard)); 
		}
	}

	@Test
	public void testGetWinnerWhenNOWinnerColumn() throws Exception {
		final CWinnerController winnerController = new CWinnerController(); 
		final int boardSize = 3;
		
		for(int i = 0; i<boardSize; i++) {
			final CField gameBoard = new CField(boardSize);

			for(int j=0; j<boardSize-1; j++) {
				gameBoard.setFigure(new Point(j,i), EFigure.X);
			}
//			gameBoard.setFigure(new Point(boardSize-1,i), EFigure.O);
			assertNull(winnerController.getWinner(gameBoard)); 
		}
	}
}
