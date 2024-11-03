
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int NUM_THREADS = 4;
        int ARRAY_SIZE = 20;
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();


        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(100); 
        }


        int partSize = ARRAY_SIZE / NUM_THREADS;
        ThreadSum[] threads = new ThreadSum[NUM_THREADS];


        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * partSize;
            int end = start + partSize;
            threads[i] = new ThreadSum(array, start, end, i + 1);
            threads[i].start();
        }


        int totalSum = 0;
        for (ThreadSum thread : threads) {
            try {
                thread.join();
                totalSum += thread.getSum();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida: " + e.getMessage());
            }
        }

        System.out.println("\nSoma total dos elementos do array: " + totalSum);
    }
}
