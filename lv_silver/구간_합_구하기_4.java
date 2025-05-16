package lv_silver;
import java.io.*;
import java.util.*;

public class 구간_합_구하기_4 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        int[] a = new int[N];
        int[] S = new int[N + 1];
        int start, end;

        S[0] = 0;

        for (int i = 0; i <N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            S[i + 1] = a[i] + S[i];
        }
        
        StringBuffer bf = new StringBuffer();
        
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            bf.append((S[end] - S[start - 1]) + "\n");
        }
        System.out.println(bf.toString());
    }
}