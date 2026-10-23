import java.util.*;
public class Maxpq {

    public static void maxHeapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }

    public static void maxHeapSort(int arr[]) {
        int n = arr.length;

       
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }


   
    public static void minHeapify(int arr[], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(arr, n, smallest);
        }
    }

    public static void minHeapSort(int arr[]) {
        int n = arr.length;

  
        for (int i = n / 2 - 1; i >= 0; i--)
            minHeapify(arr, n, i);

   
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            minHeapify(arr, i, 0);
        }

    
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public static void priorityQueue() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(50);

        System.out.println("\nPriority Queue:");

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxArr[] = arr.clone();
        int minArr[] = arr.clone();

  
        maxHeapSort(maxArr);

        System.out.println("\nSorted using Max Heap:");
        for (int x : maxArr)
            System.out.print(x + " ");

  
        minHeapSort(minArr);

        System.out.println("\n\nSorted using Min Heap:");
        for (int x : minArr)
            System.out.print(x + " ");

        priorityQueue();

        sc.close();
    }
}

