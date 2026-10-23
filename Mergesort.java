public class Mergesort {

    static int count = 0;

    public static void mergesort(int arr[], int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;

            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {

                arr[k] = left[i];
                i++;

            } else {

                arr[k] = right[j];

                count = count + 1;

                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]) {

        int arr[] = {10,20,30,40,50,100,90,80,70,60};

        mergesort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Total number of shifts: " + count);
    }
}