class Solution {
    static int countBits(int n, long A[]) {
        // code here
        int mod=1000000007;
        long sum=0;
        for(int i=0;i<32;i++){
            long one=0;
            long zero=0;
            for(int j=0;j<n;j++){
                long bit=(A[j]>>(long)i)&1;
                if(bit==1){
                    one++;
                }else zero++;
            }
            sum=(sum+(((1L*one*zero)%mod)*2)%mod)%mod;
        }
        
        return (int)(sum);
        
    }
}