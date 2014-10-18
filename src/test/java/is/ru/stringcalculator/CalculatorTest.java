package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

	@Test
	public void testMultipleNumbers2(){
	assertEquals(15, Calculator.add("1,2,3,4,5"));
	}
	
	@Test
	public void testNewLines(){
	assertEquals(4,Calculator.add("1\n2,1"));
	}
	
	@Test
	public void testDiffDelimeter(){
	assertEquals(5,Calculator.add("//;2;3"));
	}

	@Test
	public void testExpectedException(){
	try {
	Calculator.add("-2");
	}
	catch(IllegalArgumentException e){
	assertEquals("Negatives not allowed: -2",e.getMessage());
	}
	}
	
	@Test
	public void testExpectedException2(){
	try{
	Calculator.add("3,-4,5,-2");
	}
	catch(IllegalArgumentException e){
	assertEquals("Negatives not allowed: -4,-2",e.getMessage());
	}
	}

	@Test
	public void testForBigNumbers(){
	assertEquals(6,Calculator.add("1,1005,3,2000,2"));
	}

	@Test
	public void testSingleNumber(){
	assertEquals(5,Calculator.add("5"));
	}
}
