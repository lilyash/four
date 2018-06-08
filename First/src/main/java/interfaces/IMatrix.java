package interfaces;

public interface IMatrix {
    double getElement(int findex,int sindex) throws MatrixException;
    void setElement (int findex,int sindex, double element) throws MatrixException;
    double getDeterminant();
    int getN();
}
