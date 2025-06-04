import java.util.*;
import java.io.*;

// 11004
public class k번째수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a,0, N - 1, K - 1);
        
        System.out.println(a[K - 1]);
    }

    public static void quickSort(int[] a, int start, int end, int K) {
        if (start >= end) {
            return;  // 종료 조건
        }
        int pivot = partition(a, start, end);
        // pivot == k
        if (pivot == K) {
            return;
        }
        // pivot > k
        else if (pivot > K) {
            quickSort(a, start, pivot - 1, K);  // 왼쪽 부분 정렬
        // pivot < k    
        } else {
            quickSort(a, pivot + 1, end, K);    // 오른쪽 부분 정렬
        }
    }

    public static int partition(int[] a, int start, int end) {
        int M = (start + end) / 2;
        swap(a, start, M);  // 중앙값을 시작점으로 이동

        int pivot = a[start];
        int i = start + 1;
        int j = end;

        while(i <= j) {
            while(j >= start + 1 && a[j] > pivot) j--;
            while(i <= end && a[i] < pivot) i++;
            if (i <= j) {
                swap(a, i, j);
            }
        }
        a[start] = a[j];
        a[j] = pivot;
        return j;
    }
    
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
