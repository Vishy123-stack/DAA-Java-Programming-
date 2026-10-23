public class Selectionsort {
    public static void Selectionsort(int arr[]){
        int n = arr.length;
        for(int i = 0 ;i<n-1;i++){
            int min=i;
            
            for(int j = i +1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    public static void main(String args[]){
        int n = 10000;
        int arr[] = new int[n];
        for(int i = 0;i<n/2;i++){
            arr[i]=n-i;
        }
        for(int i = n/2;i<n;i++){
            arr[i]=i-(n/2) + 1;
        }
        long startTime = System.nanoTime();

        Selectionsort(arr);

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " ns");
        System.out.println("Execution Time: " + (executionTime / 1000000.0) + " ms");
    }
    
}
