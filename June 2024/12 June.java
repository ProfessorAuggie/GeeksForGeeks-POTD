class Solution {
    public static int countNumberswith4(int n) {
        // code here
        int count=0;
        for(int i=1;i<=n;i++)
            if(hasFour(i)==true)
                count++;
        return count;
    }
    public static boolean hasFour(int num){
        while(num!=0){
            if(num%10==4)
                return true;
            num=num/10;
        }
        return false;
    }
}
