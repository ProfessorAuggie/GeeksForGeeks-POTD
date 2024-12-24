# Solution 1
```java
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
         int n = mat.length, m = mat[0].length;
      
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == x)
                    return true;
            }
        }
      
        return false;
    }
}
```
# Solution 2
```java
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length, m = mat[0].length;
      
        for(int i = 0; i < n; i++) {
                if(mat[i][m-1] < x){
                    continue;}
                else {
                    for(int j = 0; j < m; j++){
                        if(mat[i][j]==x)
                            return true;
                    }   
                }
            }
        return false;
    }
}
```
