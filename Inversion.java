import java.util.*;
public class Inversion{
    static int count = 0;
    public static void mergesort(int A[],int low , int high){
        if(low<high){
            int mid = (low+high)/2;
            mergesort(A,low,mid);
            mergesort(A,mid+1,high);
            merge(A,low,mid,high);
        }
    }
    public static void merge(int A[],int low,int mid,int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i = 0;i<n1;i++){
            left[i]=A[low+i];
        }
        for(int j =0;j<n2;j++){
            right[j]=A[mid+1+j];
        }

        int i=0;
        int j=0;
        int k=low;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                A[k]=left[i];
                i++;
            }
            else{
                A[k]=right[j];
                count = count + (n1-i);
                j++;
            }
            k++;
        }
        while(i<n1){
            A[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            A[k]=right[j];
            j++;
            k++;
        }
    }
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements:");
        int n = sc.nextInt();
        System.out.println("enter elements:");
        int A[]=new int[n];
        for(int i =0;i<n;i++){
            A[i]=sc.nextInt();
        }
        
        mergesort(A,0,A.length-1);
        System.out.println("Sorted array:");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println();

        System.out.println("Total number of inversions: " + count);
        sc.close();
    }
}

