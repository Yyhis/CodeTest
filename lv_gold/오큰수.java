package lv_gold;


import java.util.*;
import java.io.*;

// 17298.
public class 오큰수 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[N];

        StringBuffer bf = new StringBuffer();

        for(int i=0; i<N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && result[stack.peekLast()] < result[i]) {
                result[stack.removeLast()] = result[i];
            }

            stack.addLast(i);
        }

        while(!stack.isEmpty()) {
            result[stack.removeLast()] = -1;
        }


        for(int i=0; i<N; i++) bf.append(result[i]+ " ");

        System.out.println(bf.toString());
    }
}