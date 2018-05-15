import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class MatrixTest {

    @DataProvider
    public static Object[][] testGetDeterminantData() {
        return new Object[][]{
                {1, 2, 3, 4, -2},
                {1, 0, 1, 0, 0},
                {3, 1, -1, -3, 10},
                {7, 1, 3, 4, 25},
                {5, 4, 1, 9, 41},
                {0, 0, 0, 0, 0},
                {10, 3, 6, 2, 2},
                {0, 15, 2, 55, -30},
        };
    }

    @Test
    public static void testConstructAndGetSize() throws BadSizeException {
        Matrix obj = new Matrix(5);
        assertNotNull(obj);
        assertEquals(obj.getN(), 5);
    }

    @Test
    public static void testGetAndSetElement() throws BadSizeException, NonInvertableException, OutOfBorderException {
        Matrix obj = new Matrix(3);
        obj.setElement(1, 2, 3);
        obj.setElement(0, 6, 4);
        obj.setElement(3, 9, 7);
        obj.setElement(3, 6, 0);
        obj.setElement(69, 7, 10);
        obj.setElement(4, 8, 9);
        obj.setElement(0, 2, 3);
        obj.setElement(6, 2, 0);
        obj.setElement(3, 0, 0);
        obj.setElement(1, 7, 0);

        assertEquals(obj.getElement(0, 0), 1);
        assertEquals(obj.getElement(0, 1), 10);
        assertEquals(obj.getElement(0, 2), 5);
        assertEquals(obj.getElement(1, 0), 4);
        assertEquals(obj.getElement(1, 1), 8);
        assertEquals(obj.getElement(1, 2), 9);
        assertEquals(obj.getElement(2, 0), 17);
        assertEquals(obj.getElement(2, 1), 51);
        assertEquals(obj.getElement(2, 2), 101);
    }

    @Test(dataProvider = "testGetDeterminantData")
    public static void testGetDeterminant(double one, double two, double three, double four, double five, double six,
                                          double seven, double eight, double nine, double result) throws BadSizeException,
            OutOfBorderException, NonInvertableException {

        Matrix obj = new Matrix(3);
        obj.setElement(0, 0, one);
        obj.setElement(0, 1, two);
        obj.setElement(0, 2, three);
        obj.setElement(1, 0, four);
        obj.setElement(1, 1, five);
        obj.setElement(1, 2, six);
        obj.setElement(2, 0, seven);
        obj.setElement(2, 1, eight);
        obj.setElement(2, 2, nine);
        assertEquals(obj.getDeterminant(), result, 0.001);
    }

@Test(dataProvider = "testGetDeterminantData")
public static void testGetDeterminantModify(double one, double two, double three, double four, double five, double six,
                                            double seven, double eight, double nine, double result) throws BadSizeException,
                                            OutOfLineException,OutOfBorderException, NonInvertableException{
    Matrix obj = new Matrix(3);
    obj.setElement(0, 0, one);
    obj.setElement(0, 1, two);
    obj.setElement(0, 2, three);
    obj.setElement(1, 0, four);
    obj.setElement(1, 1, five);
    obj.setElement(1, 2, six);
    obj.setElement(2, 0, seven);
    obj.setElement(2, 1, eight);
    obj.setElement(2, 2, nine);
    assertEquals(obj.getDetModify(), result, 0.001);

}
}