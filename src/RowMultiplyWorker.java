
public class RowMultiplyWorker implements Runnable {
    private final int[][] result;
    private int[][] matrix1;
    private int[][] matrix2;
    private final int row;

    public RowMultiplyWorker(UsualMatrix result, UsualMatrix matrix1, UsualMatrix matrix2, int row) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    @Override
    public void run() {
        for(int j = 0; j < input.getLength(); j++) {
            for(int k = 0; k < length; k++)
                tmp += this.getElement(i, k) * input.getElement(k, j);
            result.setElement(i, j, tmp);
            tmp = 0;
        }
    }
}
