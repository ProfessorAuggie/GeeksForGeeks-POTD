//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int xor = 0, x = 0, y = 0;
        
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        

        int set_bit = xor & ~(xor - 1);
        
        for (int i = 0; i < n; i++) {
            if ((arr[i] & set_bit) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & set_bit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return new int[] {x, y}; 
            }
        }
        return new int[] {y, x}; 
    }
}
