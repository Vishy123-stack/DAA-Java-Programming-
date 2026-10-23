#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, j;

    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter %d distinct integers:\n", n);
    for(i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int la = -1, sla = -1, min;
    
    int la1, lb1, sla2, slb2, min1, min2;

    min = abs(arr[0] - arr[1]);
    min1 = arr[0];
    min2 = arr[1];

    for(i = 0; i < n - 1; i++) {
        for(j = i + 1; j < n; j++) {
            int diff = abs(arr[i] - arr[j]);

            if(diff > la) {
                sla = la;
                sla2 = la1;
                slb2 = lb1;
                la = diff;
                la1 = arr[i];
                lb1 = arr[j];
            }
            else if(diff > sla && diff != la) {
                sla = diff;
                sla2 = arr[i];
                slb2 = arr[j];
            }
            
            if(diff < min) {
                min = diff;
                min1 = arr[i];
                min2 = arr[j];
            }
        }
    }

    printf("\nLargest Difference = %d (Pair: %d, %d)", la, la1, lb1);
    printf("\nSecond Largest Difference = %d (Pair: %d, %d)", sla, sla2, slb2);
    printf("\nMinimum Difference = %d (Pair: %d, %d)\n", min, min1, min2);

    return 0;
}
