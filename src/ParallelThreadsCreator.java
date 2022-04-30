
import java.util.ArrayList;
import java.util.List;

public class ParallelThreadsCreator {
    public static void multiply(UsualMatrix firstMatrix, UsualMatrix secondMatrix, UsualMatrix result) {
        List<Thread> threadsList = new ArrayList<>();
        int firstRows = firstMatrix.width;
        for (int i = 0; i < firstRows; i++) {
            RowMultiplyWorker task = new RowMultiplyWorker(result, firstMatrix, secondMatrix, i);
            Thread thread = new Thread(task);
            thread.start();
            threadsList.add(thread);
            if (threadsList.size() % 13 == 0)
                waitForthreadsList(threadsList);
        }
    }
    
    private static void waitForthreadsList(List<Thread> threadsList) {
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadsList.clear();
    }
}
