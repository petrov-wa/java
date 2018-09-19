package Lessons.Kavalevsky.M_10_X0.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CPlayerTest {

	@Test
	public void testGetName() {
		final String inputValue = "Shlava";
		final String expectedValue = inputValue; 
		
		final CPlayer player = new CPlayer(inputValue, null);
		final String actualValue = player.getName();
				
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetFigure() {
		final EFigure inputValue = EFigure.X; 
		final EFigure expectedValue = inputValue;
		
		final CPlayer player = new CPlayer(null, inputValue);
		final EFigure actualFigure = player.getFigure(); 
			
		assertEquals(expectedValue, inputValue); 
	}

}
