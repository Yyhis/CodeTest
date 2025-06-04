import java.io.*;

public class 수정렬_2 {
    static int[] a;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
    
        a = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(a[i] + "\n");
        }
        
        bw.flush();
    }

    public static void mergeSort(int start, int end) {
        // 적어도 2개 이상만
        if (end - start < 1) {
            return;  // 종료 조건
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid);  // 왼쪽 부분 정렬
        mergeSort(mid + 1, end); // 오른쪽 부분 정렬

        merge(start, mid, end);  // 병합
    }

    public static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        // i는 왼쪽 부분, j는 오른쪽 부분 중 작은 수를 선택하고 index 증가
        // i나 j 중 하나가 끝날 때까지
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 남은 배열을 전부 넣기 (while 2개지만 하나만 실행됨)
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

        // 정렬된 배열을 원래 배열에 복사
        for (int l = start; l <= end; l++) {
            a[l] = temp[l];
        }
    }
}
