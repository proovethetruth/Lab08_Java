
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Date start = new Date();

        UsualMatrix firstMatrix = new UsualMatrix(100, 100);
        firstMatrix.fillWithRnd();
        UsualMatrix secondMatrix = new UsualMatrix(100, 100);
        secondMatrix.fillWithRnd();

        UsualMatrix result = new UsualMatrix(firstMatrix.length, secondMatrix.length);
        ParallelThreadsCreator.multiply(firstMatrix, secondMatrix, result);
        // OR
        result = firstMatrix.product(secondMatrix);

        Date end = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));
    }
}
