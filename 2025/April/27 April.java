//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        int sign=(s1.charAt(0)=='-'^s2.charAt(0)=='-')?-1:1;
        if(s1.charAt(0)=='-') s1=s1.substring(1);
        if(s2.charAt(0)=='-') s2=s2.substring(1);
        s1=s1.replaceFirst("^0+",""); if(s1.isEmpty()) return "0";
        s2=s2.replaceFirst("^0+",""); if(s2.isEmpty()) return "0";
        int n=s1.length(), m=s2.length(), L=n+m;
        int[] r=new int[L];
        for(int i=n-1;i>=0;i--) for(int j=m-1;j>=0;j--) r[i+j+1]+=(s1.charAt(i)-'0')*(s2.charAt(j)-'0');
        for(int i=L-1;i>0;i--){ r[i-1]+=r[i]/10; r[i]%=10; }
        int i=0; while(i<L&&r[i]==0) i++;
        StringBuilder a=new StringBuilder();
        for(;i<L;i++) a.append(r[i]);
        String ans=a.toString();
        return sign<0?"-"+ans:ans;
    }
}
