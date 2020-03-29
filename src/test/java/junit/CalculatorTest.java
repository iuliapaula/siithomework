package junit;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Scanner scanner = new Scanner(System.in);

//test calculator when there is only one number provided
@Test
public void testOneInput() {
    Calculator calculator = new Calculator("3 m", "mm");
    double result = calculator.calculateExpression();
    assertEquals(3000, result, 0);
}

//test calculator with two numbers
 @Test
public void testAddition() {
    Calculator calculator = new Calculator("2 mm + 10 mm", "mm");
    double result = calculator.calculateExpression();
    assertEquals(12, result, 0);
}

//test operation with multiple numbers
    @Test
    public void testMultipleInputs() {
    Calculator calculator = new Calculator("1 mm + 2 mm + 3 mm + 14 mm", "mm");
    double result = calculator.calculateExpression();
    assertEquals(20, result, 0);
    }

    //test operation with all unit measures and output in mm
@Test
public void multipleMeasureUnitsMm() {
    Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "mm");
    double result = calculator.calculateExpression();
    assertEquals(1002345, result, 0);
}

    //test operation with all unit measures and output in cm
    @Test
    public void multipleMeasureUnitsCm() {
        Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "cm");
        double result = calculator.calculateExpression();
        assertEquals(100234.5, result, 0);
    }

    //test operation with all unit measures and output in dm
    @Test
    public void multipleMeasureUnitsDm() {
        Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "dm");
        double result = calculator.calculateExpression();
        assertEquals(10023.45, result, 0);
    }

    //test operation with all unit measures and output in m
    @Test
    public void multipleMeasureUnitsM() {
        Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "m");
        double result = calculator.calculateExpression();
        assertEquals(1002.345, result, 0);
    }

    //test operation with all unit measures and output in m
    @Test
    public void multipleMeasureUnitsKm() {
        Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "km");
        double result = calculator.calculateExpression();
        assertEquals(1.002345, result, 0);
    }

    //test operation with multiple operations and output in mm
@Test
    public void multipleOperationsMm() {
    Calculator calculator = new Calculator("100 mm + 30 mm - 5 mm + 2 mm", "mm");
    double result = calculator.calculateExpression();
    assertEquals(127, result, 0);
}

    //test operation with multiple operations and output in m
    @Test
    public void multipleOperationsM() {
        Calculator calculator = new Calculator("100 mm + 30 mm - 5 mm + 2 mm", "m");
        double result = calculator.calculateExpression();
        assertEquals(0.127, result, 0);
    }
}
