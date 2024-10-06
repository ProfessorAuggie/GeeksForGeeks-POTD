//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    private int[] dx = {-1, 0, 1, 0, 1, -1, -1, 1};
    private int[] dy = {0, -1, 0, 1, 1, 1, -1, -1};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] grid, int n, int m) {
        grid[x][y] = '0';  // Mark the current cell as visited

        for (int k = 0; k < 8; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (isValid(newX, newY, n, m) && grid[newX][newY] == '1') {
                dfs(newX, newY, grid, n, m);
            }
        }
    }

    private boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
