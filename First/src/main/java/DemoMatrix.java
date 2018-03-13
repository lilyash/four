import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.Serializable;

// чтение матрицы из потока
public class DemoMatrix {
    public static void readMatrix(Scanner str, Matrix matrix){
        for(int i=0; i<matrix.getN();i++){
            for(int j=0; j<matrix.getN();j++){
                matrix.setElement(i, j, str.nextDouble());
            }
        }
    }

    // Вывод матрицы в текстовый поток в виде квадратной матрицы
    public static void writeMatrix(Matrix matrix, BufferedWriter writer) throws IOException {
        for(int i=0; i<matrix.getN();i++){
            for(int j=0; j<matrix.getN();j++){
                writer.write(matrix.getElement(i,j) + " ");
            }
            writer.write("\n");
        }
    }


    // Сумма всех элементов в матрице
    public static double sumElem(Matrix matrix){
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
    public static void main(String[] args){
        try{
            Matrix objA = new Matrix(4);
            InvertableMatrix objB= new InvertableMatrix(3);
            try {
                Scanner str = new Scanner(new FileInputStream("C:\\Users\\Student\\IdeaProjects\\First\\read.txt"));
            }catch (IOException e){
                System.err.println("Ошибка заполнения из файла");
            }

        }catch (BadSizeException e){
            System.err.println("Неправильно задан размер.");
        }


    }
}
