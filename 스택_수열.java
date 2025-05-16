import java.util.*;

// 1874
public class 스택_수열 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        StringBuffer bf = new StringBuffer();

        for (int i =0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        boolean result = true;
        int num = 1;

        for (int i = 0; i < a.length; i++) {
            if(a[i] >= num) {
                while(a[i] >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int s = stack.pop();

                if(s > a[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
    if (result) System.out.println(bf.toString());
        
    }
}