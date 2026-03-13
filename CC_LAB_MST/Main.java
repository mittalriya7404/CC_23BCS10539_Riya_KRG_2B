import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=s.nextInt();
        }
        int result=0;

        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<n;j++){
                int bit=(nums[j]>>i)&1;
                if(bit==1)count++;

            }
            if(count%3!=0){
                result=result|(1<<i);
            }
        }
        System.out.println(result);
    }
}