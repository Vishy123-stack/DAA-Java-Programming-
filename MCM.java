public class MCM {

     public static void printParenthesis(int split[][],int i,int j){
        if(i+1==j){
            System.out.print("A"+(i+1));
            return;
        }
        System.out.print("(");
        printParenthesis(split, i, split[i][j]);
        printParenthesis(split, split[i][j], j);
        System.out.print(")");
    }

    public static void matrixmultiplication(int arr[]){
        int n = arr.length;
        int tbl[][]= new int[n][n];
        int split[][]=new int[n][n];

        for(int i = 2;i<n;i++){
            for(int j = 0;j<n-i;j++){
                int k = i+j;
                tbl[j][k]=Integer.MAX_VALUE;

                for(int l = j+1;l<k;l++){
                    int cost = tbl[j][l]+tbl[l][k]+arr[j]*arr[l]*arr[k];
                    if (cost<tbl[j][k]){
                        tbl[j][k]=cost;
                        split[j][k]=l;
                    }
                }

            }
        }
        System.out.println("Minimum scalar multiplications = " + tbl[0][n - 1]);

        System.out.print("Optimal parenthesization = ");
        printParenthesis(split, 0, n - 1);
    }

    public static void main(String args[]){
        int arr[] = {2,1,3,4};
        matrixmultiplication(arr);
    }
    
}

