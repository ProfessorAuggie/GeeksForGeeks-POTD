class Solution {
    static String armstrongNumber(int n) {
        // code here
        int sum=0;
        int num=n;
        while(num>0){
            int l=num%10;
            sum+=Math.pow(l,3);
            num/=10;
        }
        if(sum==n)
            return "true";
        return "false";
    }
}
