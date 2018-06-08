package matrixes;

import interfaces.IInvertableMatrix;
import interfaces.MatrixException;
import interfaces.NonInvertableException;

import java.io.Serializable;

public class InvertableMatrix extends Matrix implements IInvertableMatrix, Serializable {
    
    public InvertableMatrix(int N) throws MatrixException {
        super (N);
        for(int i=0; i< N; i++){
            super.setElement(i, i, 1);
        }
    }
    public InvertableMatrix(Matrix matrix) throws NonInvertableException {
        super(matrix);
        if(matrix.getDeterminant()==0.0){
            throw new NonInvertableException();
        }
    }

    @Override
    public void setElement(int findex, int sindex, double element) throws MatrixException {
        double buf = this.getElement(findex, sindex);
        super.setElement(findex, sindex, element);
        if (Math.abs(this.getDeterminant()) < 1e-6) {
           super.setElement(findex, sindex, buf);
           throw new NonInvertableException();
        }
    }

//    public IInvertableMatrix invertableMatrix() throws MatrixException {
//        double coeff1, coeff2;
//        InvertableMatrix res= new InvertableMatrix(this.getN());
//        InvertableMatrix buf = new InvertableMatrix(this);
//        for(int i=0; i< this.getN(); i++){
//            if(buf.getElement(i,i)==0){
//                for(int j=0; j< this.getN(); j++){
//                    if(buf.getElement(j,i)!=0.0){
//                        for(int k=0; k< this.getN(); k++){
//                            buf.swapLines(i,j);
//                        }
//                        break;
//                    }
//                }
//            }
//            res.multLine(i, 1/buf.getElement(i,i));
//            buf.multLine(i, 1/buf.getElement(i,i));
//            for(int j=i+1; j<this.getN(); j++){
//                res.addLine(i, j, -buf.getElement(j, i));
//                buf.addLine(i, j, -buf.getElement(j, i));
//            }
//        }
//        for(int i=this.getN()-1; i>=0; i--){
//            for(int j=i-1; j>=0; j--){
//                res.addLine(i, j, -buf.getElement(j, i));
//                buf.addLine(i, j, -buf.getElement(j, i));
//            }
//        }
//        return res;
//    }

    public IInvertableMatrix getInvertMatrix() throws MatrixException {
        if (Math.abs(super.getDeterminant()) < 1e-6) {
            throw new NonInvertableException();
        }
        double step;
        int size = super.getN();
        InvertableMatrix matrix = new InvertableMatrix(this);
        InvertableMatrix buffer = new InvertableMatrix(size);
//        double[] buffer = new double[size * size];
        double temp;
        for (int i = 0; i < size; i++) {
            if (matrix.getElement(i, i) == 0) {
                for (int j = 0; j < size; j++) {
                    if (matrix.getElement(j, i) != 0.0) {
                        for (int k = 0; k < size; k++) {
                            temp = matrix.getElement(i, k);
                            matrix.setElement(i, k, matrix.getElement(j, k));
                            matrix.setElement(j, k, temp);
                            temp = buffer.getElement(i, k);
                            buffer.setElement(i, k, buffer.getElement(j, k));
                            buffer.setElement(j, k, temp);
                        }
                        break;
                    }
                }
            }
            step = matrix.getElement(i, i);
            for (int j = 0; j < size; j++) {
                matrix.setElement(i,j,  matrix.getElement(i,j) / step);
                buffer.setElement(i,j,  buffer.getElement(i,j) / step);
            }
            for (int j = i + 1; j < size; j++) {
                step = matrix.getElement(j, i);
                for (int k = 0; k < size; k++) {
                    temp = matrix.getElement(j, k) - matrix.getElement(i, k) * step;
                    matrix.setElement(j, k, temp);
                    temp = buffer.getElement(j, k) - buffer.getElement(i, k) * step;
                    buffer.setElement(j, k, temp);
                }
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                step = matrix.getElement(j, i);
                for (int k = 0; k < size; k++) {
                    temp = matrix.getElement(j, k) - matrix.getElement(i, k) * step;
                    matrix.setElement(j, k, temp);
                    temp = buffer.getElement(j, k) - buffer.getElement(i, k) * step;
                    buffer.setElement(j, k, temp);
                }
            }
        }
        return buffer;
    }

}
