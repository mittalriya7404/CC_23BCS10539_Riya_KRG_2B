import java.util.*;

class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n) return res;
        int d = 256;
        int q = 101;
        int h = 1;
        for (int i=0; i<m-1;i++){
            h=(h*d)%q;
        }
        int p=0,t=0;
        for (int i=0; i< m; i++) {
            p =(d*p +pattern.charAt(i))% q;
            t = (d*t +text.charAt(i))% q;
        }
        for (int i= 0; i<= n-m;i++) {
            if (p==t){
                int j=0;
                while(j<m && text.charAt(i + j)==pattern.charAt(j)){
                    j++;
                }
                if(j==m)res.add(i);
            }
            
            if (i<n-m) {
                t=(d*(t-text.charAt(i)*h)+text.charAt(i + m))% q;
                if(t<0)t+=q;
            }
        }
        
        return res;
    }
}