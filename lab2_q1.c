#include <stdio.h>

int main()
{
    int n, i, j, k;

    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the %d positive integers:\n", n);
    for(i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    int total = 0, sum;

    for(i = 0; i < n; i++)
{
    for(j = i; j < n; j++)
    {
        
        if(i == j)
            continue;

        
        if(i == 0 && j == n - 1)
            continue;

        sum = 0;

        printf("[");

        for(k = i; k <= j; k++)
        {
            printf("%d", arr[k]);
            sum += arr[k];

            if(k < j)
                printf(",");
        }

        printf("] = %d\n", sum);

        total += sum;
    }
}

    printf("Sum of all non-trivial subarrays = %d\n", total);

    return 0;
} 