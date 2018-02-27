import java.util.Arrays;

public class InvertableMatrix implements IInvertableMatrix {
    private int N;
    private double[] matrix;
    private double determinant;

    public InvertableMatrix(int N) throws BadSizeException {
        if (N<=0){
            throw new BadSizeException();
        }
        matrix = new double[N*N];
        this.N=N;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvertableMatrix that = (InvertableMatrix) o;

        if (N != that.N) return false;
        if (Double.compare(that.determinant, determinant) != 0) return false;
        return Arrays.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = N;
        result = 31 * result + Arrays.hashCode(matrix);
        temp = Double.doubleToLongBits(determinant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getElement(int findex, int sindex) {
        return matrix[N*findex+sindex];
    }

    public void setElement(int findex, int sindex, double element) {
        matrix[N*findex+sindex]= element;
    }

    public double determinant() {
        double det=determinant;
        boolean flag=false;
        if(!flag) {
            det=1;
            int h = 0;
            double buf2;
            double[] buf = new double[N*N];
            for(int i=0; i<N*N; i++){
                buf[i]=matrix[i];
            }
            for (int i = 1; i < N; i++) {
                if (buf[h] == 0.0) {
                    for(int k=0; k<N; k++){
                        if(buf[k*N+h]!=0){
                            for(int t=0; t<N; t++){
                                buf[h+t]=buf[h+t]+buf[k*N+h+t];
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

    public void getInvertMatrix() {
        double[] reserve= new double[N*N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                reserve[i*N+j]= matrix[j*N+i]/this.determinant();
            }
        }
        matrix=reserve;
    }
}
