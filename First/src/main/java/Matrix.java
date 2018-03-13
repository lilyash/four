import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements IMatrix, Serializable {
    private int N;
    private double[] matrix;
    private double determinant;
    private boolean flag;

    public Matrix(int N) throws BadSizeException {
        if (N <= 0) {
            throw new BadSizeException();
        } else {
            this.N = N;
            matrix = new double[N * N];
            flag = false;
        }
    }

    public Matrix(Matrix matrix) {
        this.N = matrix.N;
        this.flag = matrix.flag;
        this.determinant = matrix.determinant;
        this.matrix = new double[this.N * this.N];
        for (int i = 0; i < N * N; i++) {
            this.matrix[i] = matrix.matrix[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (N != matrix1.N) return false;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = N;
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }


    public double getElement(int findex, int sindex) throws OutOfBorderException {
        if (findex >= this.N || sindex >= this.N) {
            throw new OutOfBorderException();
        }
        return matrix[N * findex + sindex];
    }

    public void setElement(int findex, int sindex, double element)throws OutOfBorderException, NonInvertableException {
        if (findex >= this.N || sindex >= this.N) {
            throw new OutOfBorderException();
        }
        matrix[N * findex + sindex] = element;
        flag=false;
    }

    public double determinant() {
        double det = determinant;
        boolean flag = false;
        if (!flag) {
            det = 1;
            int h = 0;
            double buf2;
            double[] buf = new double[N * N];
            for (int i = 0; i < N * N; i++) {
                buf[i] = matrix[i];
            }
            for (int i = 1; i < N; i++) {
                if (buf[h] == 0.0) {
                    for (int k = 0; k < N; k++) {
                        if (buf[k * N + h] != 0) {
                            for (int t = 0; t < N; t++) {
                                buf[h + t] = buf[h + t] + buf[k * N + h + t];
                            }
                            break;
                        }
                    }
                }
                for (int q = i; q < N; q++) {
                    buf2 = buf[h + (q - i + 1) * N];
                    for (int j = 0; j < N; j++) {
                        buf[j + N * q] = buf[j + N * q] - (buf[j + (i - 1) * N] / buf[h] * buf2);
                    }
                }
                det *= buf[h];
                h += (N + 1);
            }
            det *= buf[h];
        }
        this.determinant = det;
        flag = true;
        return determinant;
    }

    public int getN() {
        return N;
    }

}