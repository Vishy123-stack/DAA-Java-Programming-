import java.util.*;
public class knapdp {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the capacity of the knapsack:");
        int n=sc.nextInt();
        System.out.println("enter the number of items:");
        int m = sc.nextInt();

        int weight[]=new int[m+1];
        int profit[]=new int[m+1];
        
        System.out.println("enter the weight of each item:");
        for(int i=1;i<=m;i++){
            weight[i]=sc.nextInt();
        }

        System.out.println("enter the profit of each item:");
        for(int i=1;i<=m;i++){
            profit[i]=sc.nextInt();
        }

        int tbl[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(weight[i]<=j){
                    tbl[i][j]=Math.max(tbl[i-1][j], profit[i]+tbl[i-1][j-weight[i]]);
                }
                else{
                    tbl[i][j]=tbl[i-1][j];
                }
            }
        }

        System.out.println("\n0-1 KNAPSACK Table:");
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(tbl[i][j] + "\t");
            }
            System.out.println();
        }   

        System.out.println("the maximum profit = "+ tbl[m][n]); 
        sc.close();   
    }
}
