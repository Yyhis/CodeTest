import java.util.*;
import java.io.*;

public class 수정렬_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] a = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        
        int max = Arrays.stream(a).max().orElse(0);
        
        // 10000 이하라 10^5 => 5자리
        radixSort(a, max);
        
        for (int i = 0; i < N; i++) {
            bw.write(a[i] + "\n");
        }
        
        bw.flush();
    }

    public static void radixSort(int[] a, int max) {
        int N = a.length;
        int[] output = new int[N];

        // 자리수별로 정렬
        // 1 10 100 1000 10000

        for (int exp = 1; exp <= max; exp *= 10) { 
            int[] bucket = new int[10]; // 0~9까지의 숫자 분포 및 합 배열

            for (int i = 0; i < N; i++) {
                bucket[(a[i] / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1]; // 분포에 따른 자리의 index 계산
                // ex) 0~2까지의 숫자 분포가 [1, 3, 5]라면 인덱스는 0 ~ 1, 2 ~ 4, 5 ~ 9 까지 => 합 배열이 나옴 [1, 4, 9]
            }

            for (int i = N - 1; i >= 0; i--) {
                int index = (a[i] / exp) % 10; 
                output[bucket[index] - 1] = a[i]; 
                bucket[index]--; 
            }

            for (int i = 0; i < N; i++) {
                a[i] = output[i]; // 정렬된 배열을 원래 배열에 저장
            }
        }
    }
}
