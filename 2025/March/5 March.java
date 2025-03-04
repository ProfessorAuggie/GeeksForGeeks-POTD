//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int arr[]) {
        List<Integer> lisList = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(lisList, num);
            if (idx < 0) {
                idx = -(idx + 1); // Convert to insertion index
            }
            if (idx < lisList.size()) {
                lisList.set(idx, num);
            } else {
                lisList.add(num);
            }
        }

        return lisList.size();
    }
}
