import java.util.*;

// 1546
public class 평균 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] Nums = new int[N];

        int max = 0;

        for (int i = 0; i < Nums.length; i++) {
            Nums[i] = sc.nextInt();
            if (max <= Nums[i]) max = Nums[i];
        }

        double sum = 0.0;

        for (int j = 0; j < Nums.length; j++){
            sum += (double) Nums[j]/max*100;    
        }
        
        double avg = sum / N;

        System.out.println(avg);
    }
}