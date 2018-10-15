package M_10_X0.View;

import java.awt.Point;
import java.util.Scanner;

import M_10_X0.Controller.CCurrentMoveController;
import M_10_X0.Controller.CMoveController;
import M_10_X0.Controller.CWinnerController;
import M_10_X0.Model.CField;
import M_10_X0.Model.CGame;
import M_10_X0.Model.EFigure;
import M_10_X0.Model.Exceptions.AlreadyOccupiedException;
import M_10_X0.Model.Exceptions.InvalidPointException;
import M_10_X0.Model.Exceptions.NoWinnerException;

public class CConsoleView {

    private final CCurrentMoveController currentMoveController = new CCurrentMoveController();
    private final CWinnerController winnerController = new CWinnerController(); 
    
    public void show(final CGame game) {
	final CField gameBoard = game.getField();
	System.out.format("Game name: %s\n",  game.getName());

	for(int row=0; row<gameBoard.getSize(); row++) {
	    if(row>0) {
		printSepartor(gameBoard); 
	    }
	    printBoardLine(gameBoard, row);
	}
//		printSepartor(gameBoard); 
    }

    public boolean move(final CGame game) {
	final CField gameBoard = game.getField(); 
	final EFigure currentFigure = this.currentMoveController.currentMove(gameBoard);
	final CMoveController moveController = new CMoveController(); 
	if(currentFigure == null) {
	    try {
		final EFigure winner = this.winnerController.getWinner(gameBoard);
		System.out.format("We got a winner: %s. Game over.", winner);
	    } catch (NoWinnerException e) {
		/*
		 * No winner 
		 * */
		System.out.println("No winner and no more turns left! Game over.");
	    }
	    return false; 
	}
	System.out.format("Enter turn point for player %s", currentFigure);
	final Point point = askPoint();  
	
	try {
	    moveController.applyFigure(gameBoard, point, currentFigure);
	} catch (AlreadyOccupiedException | InvalidPointException e) {
	    e.printStackTrace();
	    System.out.println("Entered point is invlid!");
	}
	return true; 
    }

    private Point askPoint() {
	return new Point(askCoordinate("row"), askCoordinate("column"));  
    }

    private int askCoordinate(final String coordinateName) {
	System.out.format("Please, enter %s:", coordinateName);
	Scanner in= new Scanner(System.in);
	return in.nextInt(); 
    }

    private void printBoardLine(final CField gameBoard, final int row){

	for(int column=0; column<gameBoard.getSize(); column++) {
	    final EFigure figure ;
	    try {
		figure = gameBoard.getFigure(new Point(row, column));
	    } catch(InvalidPointException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	    }
	    System.out.format("%s %s ", (column>0?"|":""), (figure != null? figure : " ")); 
//	    System.out.print("|");
//	    System.out.print(figure != null? figure : " ");
//	    try {
//		
//	    }
	}
	System.out.println();
    }

    private void printSepartor(final CField gameBoard) {
	for(int i=0; i<gameBoard.getSize(); i++) {
	    if(i!=0) {
		System.out.print("+");
	    }
	    System.out.print("---");
	}
	System.out.println();
    }
}
