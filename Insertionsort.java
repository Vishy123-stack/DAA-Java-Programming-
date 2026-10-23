public class Insertionsort {

    public static void Insertionsort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {

        int n = 10000;

        int best[] = new int[n];
        for (int i = 0; i < n; i++) {
            best[i] = i + 1;
        }

        long start = System.nanoTime();
        Insertionsort(best);
        long end = System.nanoTime();

        System.out.println("Best Case:");
        System.out.println("Execution Time: " + (end - start) + " ns");
        System.out.println("Execution Time: " + ((end - start) / 1000000.0) + " ms");

        int worst[] = new int[n];
        for (int i = 0; i < n; i++) {
            worst[i] = n - i;
        }

        start = System.nanoTime();
        Insertionsort(worst);
        end = System.nanoTime();

        System.out.println("\nWorst Case:");
        System.out.println("Execution Time: " + (end - start) + " ns");
        System.out.println("Execution Time: " + ((end - start) / 1000000.0) + " ms");
    }
}