package matrixes;

import interfaces.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class InvertTest {

@DataProvider
public static Object[][] testGetDeterminantData() {
    return new Object[][]{
            { new double[]{1, 5, 7, 8, 7, 8, 7, 0, 1}, -96.0},
            {2, 2, 3, 1, 4, 2, 1, 7, 1, -9.0},
            {0, 0, 1, 4, 0, 1, 5, 2, 1, 8.0},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 1},

    };
}

@DataProvider
public static Object[][] testGetDeterminant() {
    return new Object[][]{
            { new double[]{1, 5, 7, 8, 7, 8, 7, 0, 1}, -96.0}
    };
}

@Test
public static void testConstructAndGetElement() throws MatrixException {
    InvertableMatrix obj = new InvertableMatrix(36);
    assertNotNull(obj);
    assertEquals(obj.getN(), 36);
}

@Test

public static void testSetAndGetElement() throws MatrixException {
    InvertableMatrix obj = new InvertableMatrix(2);
    obj.setElement(0,0,2);
    obj.setElement(0,1,8);
    obj.setElement(1,0,7);
    obj.setElement(1,1,9);
    assertEquals(obj.getElement(0,0),2.0);
    assertEquals(obj.getElement(0,1),8.0);
    assertEquals(obj.getElement(1,0),7.0);
    assertEquals(obj.getElement(1,1),9.0);
}

@Test (dataProvider = "testGetDeterminant")
public static void testGetDeterminant(double[] arg, double expected) throws BadSizeException {
    Matrix obj = new Matrix(arg);
    assertEquals(obj.getDeterminant(), expected, 1e-5);
}


@Test (dataProvider = "testGetDeterminant")
public static void testGetInverted(double[] arg, double det) throws MatrixException {
    InvertableMatrix obj = new InvertableMatrix(new Matrix (arg));
    InvertableMatrix inverted = (InvertableMatrix) obj.getInvertMatrix();
    assertNotNull(inverted);
    assertEquals(obj.mult(inverted), new InvertableMatrix(obj.getN()));
}


@Test(enabled = false)
public static void testInvertMatrix() throws MatrixException {
    InvertableMatrix fim = new InvertableMatrix(2);
    InvertableMatrix sim = new InvertableMatrix(3);
    fim.setElement(0, 0, 1.0);
    fim.setElement(0, 1, 2.0);
    fim.setElement(1, 0, 3.0);
    fim.setElement(1, 1, 4.0);

    sim.setElement(0, 0, 0);
    sim.setElement(0, 1, 0);
    sim.setElement(0, 2, 1);
    sim.setElement(1, 0, 4);
    sim.setElement(1, 1, 0);
    sim.setElement(1, 2, 1);
    sim.setElement(2, 0, 5);
    sim.setElement(2, 1, 2);
    sim.setElement(2, 2, 1);

    InvertableMatrix fimres = new InvertableMatrix(2);
    InvertableMatrix simres = new InvertableMatrix(3);
    fimres.setElement(0, 0, -2.0);
    fimres.setElement(0, 1, 1.0);
    fimres.setElement(1, 0, 1.5);
    fimres.setElement(1, 1, -0.5);

    simres.setElement(0, 0, -0.25);
    simres.setElement(0, 1, 0.25);
    simres.setElement(0, 2, 0);
    simres.setElement(1, 0, 1.0/8.0);
    simres.setElement(1, 1, -5.0/8.0);
    simres.setElement(1, 2, 0.5);
    simres.setElement(2, 0, 1);
    simres.setElement(2, 1, 0);
    simres.setElement(2, 2, 0);

//    fim.invertableMatrix();
//    sim.invertableMatrix();
//    System.out.println(sim.getElement(0,0));
//    assertEquals(fim.invertableMatrix(), fimres);
//    assertEquals(sim.invertableMatrix(), simres);
}



}
