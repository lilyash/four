package matrixes;

import interfaces.*;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

// чтение матрицы из потока
public class DemoMatrix {
    public static Matrix readMatrix(Scanner str) throws MatrixException {
        int size = str.nextInt();
        Matrix matr = new Matrix(size);
        for(int i=0; i < size; i++){
            for(int j=0; j<size; j++){
                double x = str.nextDouble();
                matr.setElement(i, j, x);
            }
        }
        return matr;
    }

    // Вывод матрицы в текстовый поток в виде квадратной матрицы
    public static void writeMatrix(Matrix matrix, BufferedWriter writer) throws IOException, OutOfBorderException {
//        BufferedWriter writer = new (bw);
        for(int i=0; i<matrix.getN();i++){
            for(int j=0; j<matrix.getN();j++){
                writer.write(matrix.getElement(i,j) + " ");
            }
            writer.write("\n");
        }
    }


    // Сумма всех элементов в матрице
    public static double sumElem(Matrix matrix) throws OutOfBorderException {
        double sum =0;
        for(int i=0; i<matrix.getN();i++){
            for(int j=0; j<matrix.getN();j++){
                sum+=matrix.getElement(i,j);
            }
        }
        return sum;
    }

    // Метод маин
    // Создание объектов класса
    // Матрицы заполняются из файла
    //
    public static void main(String[] args) throws MatrixException {
        Matrix objA ; //= new Matrix(4);
        InvertableMatrix objB ; //= new InvertableMatrix(3);

        try (Scanner str = new Scanner(new FileInputStream("first.txt"))) {
            str.useLocale(Locale.US);
            objA = readMatrix(str);
            objA.setElement(0, 0, 12);
            objA.setElement(2, 1, 19);
        } catch (OutOfBorderException ex) {
            System.out.println("1 Выход за границу матрицы");
        } catch (MatrixException | FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try (Scanner str = new Scanner(new FileInputStream("second.txt"))) {
            str.useLocale(Locale.US);
            objB = new InvertableMatrix(readMatrix(str));
            InvertableMatrix objC = (InvertableMatrix) objB.getInvertMatrix();
            System.out.println(objC.toString());
        } catch (OutOfBorderException ex) {
            System.out.println("2 Выход за границу матрицы");
        } catch (MatrixException | FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try (ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream("serOut.txt"))) {
            serOut.writeObject(new Matrix(1,2,3,4,5,6,7,8,9));
            serOut.flush();
//            serOut.close();
        } catch (IOException e) {
            System.out.println("7 Ошибка сериализации");
        }

        try (ObjectInputStream serIn = new ObjectInputStream(new FileInputStream("serOut.txt"))) {
            Matrix matrixSer = (Matrix) serIn.readObject();
            assert (new Matrix(1,2,3,4,5,6,7,8,9).equals(matrixSer));
        } catch (IOException e) {
            System.out.println("9 Ошибка десериализации");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
