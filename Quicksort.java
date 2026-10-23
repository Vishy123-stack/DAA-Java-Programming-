public class Quicksort{
    public static void quicksort(int arr[],int p,int r){
        if(p<r){
            int q = partition(arr,p,r);
            quicksort(arr, p, q-1);
            quicksort(arr, q+1, r);
        }
    }
    public static int partition(int arr[],int p,int r){
        int x = arr[r];
        int i = p-1;
        int temp;
        for (int j = p;j<=r-1;j++){
            if(arr[j]<=x){
                i=i+1;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp = arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return i+1;
    }
    public static void main(String[] args) {

    int n = 5000;

    int arr1[] = new int[n];
    int arr2[] = new int[n];


    for (int i = 0; i < n; i++) {
        arr1[i] = 10000 - i;
    }

    for (int i = 0; i < n; i++) {
        arr2[i] = i + 1;
    }

    long start1 = System.nanoTime();

    quicksort(arr1, 0, n - 1);

    long end1 = System.nanoTime();

    System.out.println("Array 1 (10000 to 5001)");
    System.out.println("Execution Time: " + (end1 - start1) + " ns");
    System.out.println("Execution Time: " + ((end1 - start1) / 1_000_000.0) + " ms");

    long start2 = System.nanoTime();

    quicksort(arr2, 0, n - 1);

    long end2 = System.nanoTime();

    System.out.println();
    System.out.println("Array 2 (1 to 5000)");
    System.out.println("Execution Time: " + (end2 - start2) + " ns");
    System.out.println("Execution Time: " + ((end2 - start2) / 1_000_000.0) + " ms");
}
}