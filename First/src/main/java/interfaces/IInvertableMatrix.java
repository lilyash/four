package interfaces;

public interface IInvertableMatrix extends IMatrix {
    IInvertableMatrix getInvertMatrix() throws MatrixException;
}
