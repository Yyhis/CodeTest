package lv_silver;
import java.io.*;
import java.util.*;

public class 구간_합_구하기_5 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N+1][N+1];
        int[][] d = new int[N+1][N+1];

        StringBuffer bf = new StringBuffer();

        // 원본 저장
        for (int i = 1; i <= N; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);

            for(int j = 1; j <= N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + a[i][j];
            }
        }

    
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = d[x2][y2] - d[x2][y1-1] - d[x1-1][y2] + d[x1-1][y1-1];
            System.out.println(result);
        }

    }
}