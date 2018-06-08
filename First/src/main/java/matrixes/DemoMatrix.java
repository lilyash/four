package matrixes;

import interfaces.BadSizeException;
import interfaces.MatrixException;
import interfaces.NonInvertableException;
import interfaces.OutOfBorderException;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

// чтение матрицы из потока
public class DemoMatrix {
    public static void readMatrix(Scanner str, Matrix matrix) throws MatrixException {
        double x=0;
        for(int i=0; i<matrix.getN();i++){
            for(int j=0; j<matrix.getN();j++){
                x = str.nextDouble();
                matrix.setElement(i, j, x);
            }
        }
    }

    // Вывод матрицы в текстовый поток в виде квадратной матрицы
    public static void writeMatrix(Matrix matrix, BufferedWriter writer) throws IOException, OutOfBorderException {
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
    public static void main(String[] args) throws NonInvertableException, OutOfBorderException {
        try{
            Matrix objA = new Matrix(4);
            InvertableMatrix objB= new InvertableMatrix(3);
            try {
                Scanner str = new Scanner(new FileInputStream("C:\\Users\\Student\\IdeaProjects\\First\\first.txt"));
                str.useLocale(Locale.US);

                try{
                    readMatrix(str, objA);
                    str = new Scanner (new FileInputStream("C:\\Users\\Student\\IdeaProjects\\First\\second.txt"));
                    readMatrix(str, objB);
                    str = new Scanner (new FileInputStream("C:\\Users\\Student\\IdeaProjects\\First\\third.txt"));
                }

                catch (OutOfBorderException ex){
                    System.out.println("Выход за границу матрицы");
                }

                try{
                    objA.setElement(0, 0, 12);
                    objA.setElement(2, 1, 19);
                }

                catch(OutOfBorderException ex){
                    System.out.println("Выход за границу матрицы");
                }

                objB.getInvertMatrix();
            }
            catch (IOException e){
                System.err.println("Ошибка заполнения из файла");
            }

            catch(NonInvertableException e){
                System.out.println("Матрица не обращается");
            }

            try{

                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Student\\IdeaProjects\\First\\outf.txt"));

                try{
                    writeMatrix(objA, writer);
                    writer = new BufferedWriter( new FileWriter("C:\\Users\\Student\\IdeaProjects\\First\\outs.txt"));
                    writeMatrix(objB, writer);
                    writer = new BufferedWriter( new FileWriter("C:\\Users\\Student\\IdeaProjects\\First\\outt.txt"));
                }

                catch (OutOfBorderException ex){
                    System.out.println(" Выход за границу матрицы");
                }
            }

            catch (IOException e) {
                System.out.println("Ошибка записи");
            }

            try(ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Student\\IdeaProjects\\First\\serOut.txt"))){
                serOut.writeObject(objA);
                serOut.flush();
                serOut.close();
            }
            catch(IOException e){
                System.out.println("Ошибка сериализации");
            }

            try(ObjectInputStream serIn = new ObjectInputStream(new FileInputStream("C:\\Users\\Student\\IdeaProjects\\First\\serOut.txt")))
            {
                Matrix matrixSer = (Matrix) serIn.readObject();
                BufferedWriter writerone = new BufferedWriter(new FileWriter("C:\\Users\\Student\\IdeaProjects\\First\\outSer.txt"));
                try{
                    writeMatrix(objA, writerone);
                }
                catch(OutOfBorderException ex){
                    System.out.println("Выход за границу матрицы");
                }
                catch(IOException e){
                    System.out.println("Ошибка десериализации");
                }
            }
        }catch (BadSizeException e){
            System.err.println("Неправильно задан размер.");
        }
        catch(Exception e){
            System.out.println("Unexpected unknown error");
        }
    }
}
