
import java.util.ArrayList;
import java.util.List;

public class ParallelThreadsCreator {
    public static void multiply(UsualMatrix firstMatrix, UsualMatrix secondMatrix, UsualMatrix result) {
        List threads = new ArrayList<>();
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
            RowMultiplyWorker task = new RowMultiplyWorker(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if (threads.size() % 10 == 0)
                waitForThreads(threads);
        }
    }
    
    private static void waitForThreads(List threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
