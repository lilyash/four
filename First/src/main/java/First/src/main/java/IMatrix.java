public interface IMatrix {
    double getElement(int findex,int sindex);
    void setElement (int findex,int sindex, double element);
    double determinant();
}
