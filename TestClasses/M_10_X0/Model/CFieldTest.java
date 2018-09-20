package M_10_X0.Model;

import static org.junit.Assert.*;
import org.junit.Test;

import M_10_X0.Model.Exceptions.AlreadyOccupiedException;
import M_10_X0.Model.Exceptions.InvalidPointException;

import java.awt.Point;

public class CFieldTest {

	@Test
	public void testGetSize() {
		final CField field = new CField(3);
		
		assertEquals(3, field.getSize()); 
	}

	@Test
	public void testSetFigure() throws InvalidPointException, AlreadyOccupiedException {
		final CField field = new CField(3);
		final Point inputPoint = new Point(0,0);
		final EFigure inputFigure = EFigure.O; 
	    final EFigure expectedFigure = inputFigure;
		//final EFigure expectedFigure = EFigure.X; 
		
		field.setFigure(inputPoint, inputFigure); 
		final EFigure actualFigure = field.getFigure(inputPoint);
		
		assertEquals(expectedFigure, actualFigure);
	}

	/* @Test
	public void testSetFigureAlreadyOccupied() throws InvalidPointException, AlreadyOccupiedException {
		final CField field = new CField();
		final Point inputPoint = new Point(0,0);
		final EFigure inputFigure = EFigure.O; 
	    final EFigure expectedFigure = inputFigure;
		//final EFigure expectedFigure = EFigure.X; 
	    
		field.setFigure(inputPoint, inputFigure);
		try {
			field.setFigure(inputPoint, inputFigure);
			fail("MUST: cell must be already accupied!"); 
		} catch(AlreadyOccupiedException e) {
			
		}
				
		final EFigure actualFigure = field.getFigure(inputPoint);
		
		assertEquals(expectedFigure, actualFigure);
	}
*/	
	
	@Test
	public void testGetFigure() throws InvalidPointException, AlreadyOccupiedException {
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(1,1); 
		final EFigure inputFigure = EFigure.O; 
		final EFigure expectedFigure = inputFigure; 
		
		field.setFigure(inputPoint, inputFigure);
		final EFigure actualFigure = field.getFigure(inputPoint); 
		
		assertEquals(expectedFigure, actualFigure); 
				
	}

	@Test
	public void testGetFigureWhenFigureIsNotSet() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(1,1); 
		final EFigure expectedFigure = null; 
		
		final EFigure actualFigure = field.getFigure(inputPoint); 
		
		// assertEquals(expectedFigure, actualFigure); 
		assertNull(actualFigure); 
	}

	@Test
	public void testGetFigureWhenWhenXlt0() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(-1,1); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: X < 0");
		} catch (final InvalidPointException e) {
			
		}
	}

	@Test
	public void testGetFigureWhenWhenYlt0() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(1,-1); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: Y < 0");
		} catch (final InvalidPointException e) {
			
		}
	}

	@Test
	public void testGetFigureWhenWhenXYlt0() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(-1,-1); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: X and Y < 0");
		} catch (final InvalidPointException e) {
			
		}
	}

	@Test
	public void testGetFigureWhenWhenXgtSIZE() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(3,1); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: X >= MAX_SIZE");
		} catch (final InvalidPointException e) {
			
		}
	}


	@Test
	public void testGetFigureWhenWhenYgtSIZE() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(1,3); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: Y >= MAX_SIZE");
		} catch (final InvalidPointException e) {
			
		}
	}

	@Test
	public void testGetFigureWhenWhenXYgtSIZE() throws InvalidPointException{
		// fail("Not yet implemented");
		final CField field = new CField(3); 
		final Point inputPoint = new Point(3,3); 
		final EFigure expectedFigure = null; 
		try {
			final EFigure actualFigure = field.getFigure(inputPoint);
			fail("MUST: X & Y  >= MAX_SIZE");
		} catch (final InvalidPointException e) {
			
		}
	}
}
