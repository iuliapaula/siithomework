//package junit;
//
//import org.junit.Test;
//
//import java.util.Scanner;
//
//import static org.junit.Assert.assertEquals;
//
//public class CalculatorTest {
//    Scanner scanner = new Scanner(System.in);
//
//
//@Test
//public void testOneInput() {
//    // atunci cand modifici parti din cod trebuie sa rulezi si testele sa vezi ca inca ruleaza cu succes
//    // in cazul de fata nu mai compileaza
//    Calculator calculator = new Calculator("3 m", "mm");
//    double result = calculator.calculateExpression();
//    assertEquals(3000, result);
//}
// @Test
//public void testAddition() {
//    Calculator calculator = new Calculator("2 mm + 10 mm", "mm");
//    double result = calculator.calculateExpression();
//    assertEquals(12, result);
//}
//
//@Test
//public void multipleMeasureUnits() {
//    Calculator calculator = new Calculator("1 km + 2 m + 3 dm + 4 cm + 5 mm", "mm");
//    double result = calculator.calculateExpression();
//    assertEquals(1002345, result);
//}
//
//@Test
//    public void multipleOperations() {
//    Calculator calculator = new Calculator("100 mm + 30 mm - 5 mm + 2 mm", "mm");
//    double result = calculator.calculateExpression();
//    assertEquals(127, result);
//}
//
//}
