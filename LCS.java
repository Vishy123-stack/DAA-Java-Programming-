
public class LCS {

    static void lcsLength(char X[], char Y[]) {
        int m = X.length;
        int n = Y.length;

        int c[][] = new int[m + 1][n + 1];
        char b[][] = new char[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X[i - 1] == Y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 'D';
                }
                else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 'U';
                }
                else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 'L';
                }
            }
        }

        System.out.println("Length of LCS = " + c[m][n]);
        System.out.print("LCS = ");
        printLCS(b, X, m, n);
        System.out.println();

        System.out.println("\nDP Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nDirection Table:");

for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
        System.out.print(b[i][j] + " ");
    }
    System.out.println();
}
    }

    static void printLCS(char b[][], char X[],
                         int i, int j) {

        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == 'D') {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X[i - 1]);
        }
        else if (b[i][j] == 'U') {
            printLCS(b, X, i - 1, j);
        }
        else {
            printLCS(b, X, i, j - 1);
        }
    }

    public static void main(String args[]) {
        char X[] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char Y[] = {'B', 'D', 'C', 'A', 'B', 'A'};

        lcsLength(X, Y);
    }
}
