package matrixes;

import interfaces.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MatrixTest {

    @DataProvider
    public static Object[][] testGetDeterminantData() {
        return new Object[][]{
                {1.0, 2.0, 3.0, 4.0, 0.0},
                {3.0, 1.0, -1.0, -3.0, 0.0},
                {7.0, 1.0, 3.0, 4.0, 0.0}
        };
    }

    @Test
    public static void testConstructAndGetSize() throws BadSizeException {
        Matrix obj = new Matrix(5);
        assertNotNull(obj);
        assertEquals(obj.getN(), 5);
    }

    @Test
    public static void testGetAndSetElement() throws MatrixException {
        Matrix obj = new Matrix(3);
        assertEquals(obj.getElement(0, 0), 0.0);
        assertEquals(obj.getElement(0, 1), 0.0);
        assertEquals(obj.getElement(0, 2), 0.0);
        assertEquals(obj.getElement(1, 0), 0.0);
        assertEquals(obj.getElement(1, 1), 0.0);
        assertEquals(obj.getElement(1, 2), 0.0);
        assertEquals(obj.getElement(2, 0), 0.0);
        assertEquals(obj.getElement(2, 1), 0.0);
        assertEquals(obj.getElement(2, 2), 0.0);

        obj.setElement(0, 0, 3);
        obj.setElement(0, 1, 4);
        obj.setElement(0, 2, 7);
        obj.setElement(1, 0, 0);
        obj.setElement(1, 1, 9);
        obj.setElement(1, 2, 3);
        obj.setElement(2, 0, 0);
        obj.setElement(2, 2, 0);
        obj.setElement(2, 2, 0);

    }

    @Test(dataProvider = "testGetDeterminantData")
    public static void testGetDeterminant(double one, double two, double three, double four,/* double five, double six,
                                          double seven, double eight, double nine, */ double result) throws MatrixException {

        Matrix obj = new Matrix(3);
        obj.setElement(0, 0, one);
        obj.setElement(0, 1, two);
        obj.setElement(1, 0, three);
        obj.setElement(1, 1, four);
//        obj.setElement(1, 1, five);
//        obj.setElement(1, 2, six);
//        obj.setElement(2, 0, seven);
//        obj.setElement(2, 1, eight);
//        obj.setElement(2, 2, nine);
        assertEquals(obj.getDeterminant(), result, 0.001);
    }

@Test(dataProvider = "testGetDeterminantData")
public static void testGetDeterminantModify(double one, double two, double three, double four,/* double five, double six,
                                            double seven, double eight, double nine, */double result) throws MatrixException {
    Matrix obj = new Matrix(3);
    obj.setElement(0, 0, one);
    obj.setElement(0, 1, two);
    obj.setElement(0, 2, three);
    obj.setElement(1, 0, four);
   // obj.setElement(1, 1, five);
   // obj.setElement(1, 2, six);
    //obj.setElement(2, 0, seven);
   // obj.setElement(2, 1, eight);
   // obj.setElement(2, 2, nine);
    assertEquals(obj.getDetModify(), result, 0.001);

}
}