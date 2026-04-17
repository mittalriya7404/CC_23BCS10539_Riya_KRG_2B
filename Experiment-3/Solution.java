class Solution {

    public int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long l=Math.min(a,b);
        long r=(long)n*l;
        long mod=(int)(1e9+7);
        long lcm=(a/gcd(a,b))*(long)b;
        while(l<r){
            long mid=l+(r-l)/2;
            long count=(mid/a)+(mid/b)-(mid/lcm);
            if(count>=n)r=mid;
            else l=mid+1;
        }
        return (int)(l%mod);
    }
}