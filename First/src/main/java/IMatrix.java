public interface IMatrix {
    double getElement(int findex,int sindex) throws OutOfBorderException;
    void setElement (int findex,int sindex, double element) throws OutOfBorderException, NonInvertableException;
    double getDeterminant();
}
