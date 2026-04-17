import java.util.*;


public class demo2 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int[] arr= new int[n];
        int power=s.nextInt();
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int score=0;
        int left=0;
        int right=n;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(helper(mid, arr, power)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(ans);
    }

    public static boolean helper(int score,int[] arr,int power){
        int max=0;
        int temp=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(power>=arr[i]){
                temp++;
                power=power-arr[i];
                max=Math.max(max,temp);
            }else if(temp>0){
                power+=arr[i];
                temp--;
            }
        }
        if(max>=score)return true;
        return false;
    }
}
