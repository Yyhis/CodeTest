import java.io.*;
import java.util.*;

public class 주몽 {

    // 0.757 ms - buffer
    // 45.207ms - scanner
    public static void main(String args[]) throws IOException {
        long startTime = System.nanoTime();
        
        // buffer vs scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // int N = sc.nextInt();
        // int M = sc.nextInt();
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];

        for (int i = 0; i <N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            // a[i] = sc.nextInt();
        }

        int count = 0;

        for (int i =0; i <N; i++) {
            for (int j=0; j < N; j++) {
                if (i <= j) continue;
                if (a[i]+a[j] == M) count++;
            }
        }

        System.out.println(count);

        long endTime = System.nanoTime();
        double executionTime = (endTime-startTime) / 1_000_000.0;
        System.out.printf("\n실행 시간: %.3f ms\n", executionTime);
    }

    // 1.293 ms
    // public static void main(String args[]) throws IOException {
    //     long startTime = System.nanoTime();
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int N = Integer.parseInt(br.readLine());
    //     int M = Integer.parseInt(br.readLine());

    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int[] a = new int[N];

    //     for (int i = 0; i <N; i++) {
    //         a[i] = Integer.parseInt(st.nextToken());
    //     }

    //     Arrays.sort(a); // 순차 정렬
    //     // 1 2 3 4 5 7

    //     int count = 0;
    //     int i = 0, j = N - 1;

    //     while(i < j) {
    //         if (a[i] + a[j] < M) {
    //             i++;
    //         }
    //         else if (a[i] + a[j] > M) {
    //             j--;
    //         }
    //         else {
    //             count++;
    //             i++;
    //             j--;
    //         }
    //     }

    //     System.out.println(count);

    //     long endTime = System.nanoTime();

    //     double executionTime = (endTime-startTime) / 1_000_000.0;
    //     System.out.printf("\n실행 시간: %.3f ms\n", executionTime);
    // }
}