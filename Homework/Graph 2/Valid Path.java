import java.util.ArrayList;

public class Solution {
    public String solve(int X, int Y, int n, int r, int[] A, int[] B) {
        int[][] vis = new int[X + 1][Y + 1];

        for (int i = 0; i <= X; i++) {
            int x1 = i;
            for (int j = 0; j <= Y; j++) {
                int y1 = j;
                for (int k = 0; k < A.length; k++) {
                    int xcentre = A[k];
                    int ycentre = B[k];
                    if ((x1 - xcentre) * (x1 - xcentre) + (y1 - ycentre) * (y1 - ycentre) <= r * r) {
                        vis[x1][y1] = -1;
                    }
                }
            }
        }

        if (vis[X][Y] == -1) {
            return "NO";
        }

        if (dfs(0, 0, X, Y, vis)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private boolean dfs(int srcx, int srcy, int destx, int desty, int[][] vis) {
        vis[srcx][srcy] = 1;
        if (srcx == destx && srcy == desty) {
            return true;
        }

        int[] delrow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delcol = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int i = 0; i < 8; i++) {
            int xnew = srcx + delrow[i];
            int ynew = srcy + delcol[i];

            if (xnew >= 0 && xnew <= destx && ynew >= 0 && ynew <= desty && vis[xnew][ynew] == 0) {
                if (dfs(xnew, ynew, destx, desty, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
