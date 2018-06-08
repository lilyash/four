package matrixes;

import interfaces.*;

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
    public Matrix(double ...arg ) throws BadSizeException {
            this.N = (int) Math.sqrt(arg.length);
            this.matrix = new double[N * N];
            this.flag = false;
            System.arraycopy(arg, 0, this.matrix, 0, arg.length);
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

    public void setElement(int findex, int sindex, double element)throws MatrixException {
        if (findex >= this.N || sindex >= this.N) {
            throw new OutOfBorderException();
        }
        matrix[N * findex + sindex] = element;
        flag=false;
    }

    public double getDeterminant() {
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
                        if (buf[k * N + h] != 0.0) {
                            for (int t = 0; t < N; t++) {
                                buf[h + t] = buf[h + t] + buf[k * N + h + t];
                            }
                            break;
                        }
                    }
                }
                if(buf[h] !=0.0){
                    for (int q = i; q < N; q++) {
                        buf2 = buf[h + (q - i + 1) * N];
                        for (int j = 0; j < N; j++) {
                            buf[j + N * q] = buf[j + N * q] - (buf[j + (i - 1) * N] / buf[h] * buf2);
                        }
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

    public void swapLines(int findex, int sindex) throws OutOfLineException {
        if (findex >= N || sindex >= N) {
            for (int i = 0; i < N; i++) {
                throw new OutOfLineException();
            }
            double step;
            for (int i = 0; i < N; i++) {
                step = matrix[findex * N + i];
                matrix[findex * N + i] = matrix[sindex * N + i];
                matrix[sindex * N + i] = step;
            }
        }
    }

    public void addLine(int subInd, int resInd, double coeff) throws OutOfLineException{
        if (subInd >= N || resInd >= N) {
            throw new OutOfLineException();
        }
        for (int i = 0; i < N; i++) {
            matrix[resInd * N + i] += matrix[subInd * N + i]*coeff;
        }
    }

    public void multLine(int index, double coeff) throws OutOfLineException{
        if(index>=N){
            throw new OutOfLineException();
        }
        for(int i=0; i< N; i++){
            matrix[index*N + i]*=coeff;
        }
    }

    public double getDetModify() throws OutOfBorderException, OutOfLineException {
        double res=this.determinant;
        if(!this.flag) {
            res = 1;
            Matrix buf = new Matrix(this);
            for (int i = 0; i < N; i++) {
                if (buf.getElement(i, i) == 0.0) {
                    int q = i;
                    boolean flags = true;
                    while (flags) {
                        if (q < N && buf.getElement(q, i) != 0.0) {
                            buf.addLine(q, i, 1);
                            flags = false;
                        }
                        q++;
                        if (q > N) {
                            flags = false;
                            res = 0;
                        }
                    }
                }
                if (res == 0) {
                    break;
                }
                for (int j = i + 1; j < N; j++) {
                    buf.addLine(i, j, -(buf.getElement(j, i) / buf.getElement(i, i)));
                }
                res *= buf.getElement(i, i);
            }
            flag = true;
        }
        return res;
    }
}
