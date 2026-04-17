import java.util.Arrays;

class Solution {

    int[] dp;
    public int helper(int[] arr, int k, int i){

        int n=arr.length;
        if(i>=n)return 0;

        if(dp[i]!=-1)return dp[i];
        int max=0;
        int sum=0;
        for(int j=i;j<n;j++){
            if(j-i<k){
            max=Math.max(arr[j], max);
            sum=Math.max(sum,max*(j-i+1)+helper(arr, k, j+1));
            }
        }

        return dp[i]=sum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp= new int[n];
        Arrays.fill(dp,-1);
        return helper(arr, k, 0);
    }
}