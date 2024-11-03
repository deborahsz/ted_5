
public class ThreadSum extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int threadID;
    private int sum;

    public ThreadSum(int[] array, int start, int end, int threadID) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.threadID = threadID;
        this.sum = 0;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadID + " - Elementos a somar: ");
        for (int i = start; i < end; i++) {
            sum += array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println("\nThread " + threadID + " - Soma parcial: " + sum);
    }

    public int getSum() {
        return sum;
    }
}
