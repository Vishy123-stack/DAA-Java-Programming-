import java.util.*;

public class Activity {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of activities:");
        int n = sc.nextInt();

        int s[] = new int[n];
        int f[] = new int[n];
        int activity[] = new int[n];

        
        System.out.println("Enter start times:");
        for(int i = 0; i < n; i++){
            s[i] = sc.nextInt();
        }

        System.out.println("Enter finish times:");
        for(int i = 0; i < n; i++){
            f[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            activity[i] = i + 1;
        }
        
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (f[i] > f[j]) {

                  
                    int temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;

                    
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;

                   
                    temp = activity[i];
                    activity[i] = activity[j];
                    activity[j] = temp;
                }
            }
        }

   
        System.out.println("\nActivities after sorting by finish time:");

        for (int i = 0; i < n; i++) {

            System.out.println("Activity " + activity[i]
                    + "  Start: " + s[i]
                    + "  Finish: " + f[i]);
        }

     
        System.out.println("\nSelected Activities:");

        int lastdone = f[0];

        System.out.println("Activity " + activity[0]
                + "  Start: " + s[0]
                + "  Finish: " + f[0]);

        int count = 1;

        for (int i = 1; i < n; i++) {

            if (s[i] >= lastdone) {

                System.out.println("Activity " + activity[i]
                        + "  Start: " + s[i]
                        + "  Finish: " + f[i]);

                lastdone = f[i];
                count++;
            }
        }

        System.out.println("\nThe number of activities selected: " + count);

        sc.close();
    }
}