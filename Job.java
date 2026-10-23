import java.util.*;

public class Job {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs:");
        int n = sc.nextInt();

        int jobs[] = new int[n];
        int p[] = new int[n];
        int d[] = new int[n];

        System.out.println("Enter profits:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println("Enter deadlines:");
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            jobs[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (p[i] < p[j]) {

                    int temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;

                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;

                    temp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = temp;
                }
            }
        }

        int maxDeadline = d[0];

        for (int i = 1; i < n; i++) {
            if (d[i] > maxDeadline) {
                maxDeadline = d[i];
            }
        }

        int slot[] = new int[maxDeadline + 1];

        int totalProfit = 0;

        System.out.println("\nSelected Jobs:");

        for (int i = 0; i < n; i++) {

            for (int j = d[i]; j >= 1; j--) {

                if (slot[j] == 0) {

                    slot[j] = jobs[i];
                    totalProfit += p[i];

                    System.out.println("Job:"+ jobs[i]+"Profit:"+p[i]+"Deadline:"+d[i]+"Slot:"+j);

                    break;
                }
            }
        }

        System.out.println("\nMaximum Profit: " + totalProfit);

        sc.close();
    }
}