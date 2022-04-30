
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        UsualMatrix firstMatrix = new UsualMatrix(1000, 1000);
        firstMatrix.fillWithRnd();
        UsualMatrix secondMatrix = new UsualMatrix(1000, 1000);
        secondMatrix.fillWithRnd();

        UsualMatrix result = new UsualMatrix(firstMatrix.length, secondMatrix.length);

        Date start = new Date();
        ParallelThreadsCreator.multiply(firstMatrix, secondMatrix, result);
        Date end = new Date();
        System.out.println("Time taken in milli seconds using Thread multiplication: " + (end.getTime() - start.getTime()));

        // start = new Date();
        // result = firstMatrix.product(secondMatrix);
        // end = new Date();
        // System.out.println("Time taken in milli seconds using manual multiplication: " + (end.getTime() - start.getTime()));
        // System.out.println("FIRST: \n" + firstMatrix);
        // System.out.println("\nSECOND: \n" + secondMatrix);
        // System.out.println("\nRESULT: \n" + result);


    }
}
