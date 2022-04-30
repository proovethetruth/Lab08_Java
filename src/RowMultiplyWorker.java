
public class RowMultiplyWorker implements Runnable {
    private UsualMatrix result;
    private UsualMatrix firstMatrix;
    private UsualMatrix secondMatrix;
    private int row;

    public RowMultiplyWorker(UsualMatrix result, UsualMatrix firstMatrix, UsualMatrix secondMatrix, int row) {
        this.result = result;
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.row = row;
    }

    @Override
    public void run() {
        for (int i = 0; i < secondMatrix.length; i++) {
            result.matrix[row][i] = 0;
            for (int j = 0; j < firstMatrix.matrix[row].length; j++)
                result.matrix[row][i] += firstMatrix.matrix[row][j] * secondMatrix.matrix[j][i];
        }
    }
}
