package lv_platinum;
import java.util.*;
import java.io.*;

// 플래티넘
public class 최솟값 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer bf = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        

        for(int i = 0; i <N; i++) {
            int now = Integer.parseInt(st.nextToken());
            
            // 최솟값이랑 그 다음 최솟값만 남기고 다 제거
            while(!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            // A(i-L+1) 이면 제거하면서 얻기
            if(!dq.isEmpty() && dq.getFirst().index <= i - L + 1) {
                bf.append(dq.removeFirst().value + " ");
            }
            else bf.append(dq.getFirst().value + " ");
        }

        System.out.println(bf.toString());
    }

    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
