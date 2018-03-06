public interface IInvertableMatrix extends IMatrix {
    void getInvertMatrix() throws NonInvertableException;
}
