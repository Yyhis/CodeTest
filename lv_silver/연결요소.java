import java.util.*;
import java.io.*;

// silver
public class 연결요소 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1]; // 1 ~ N까지
        
        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }

        int count = 0;
        
        for(int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }   
    // 1 - 2
    // visited 1, 2
    // 2 - 5
    // visited 5     
    // 5 - 1
    // all visit => circle
    // 3 - 4
    // visited 3, 4
    // 4 - 6
    // visited 6


    // 둘 다 visited false이면 count++
    public static void DFS(int v) {
        // 1: 2 5
        // 2: 1 5
        // 3: 4 
        // 4: 3 6
        // 5: 1 2
        // 6: 4
        if(visited[v]) return;
        visited[v] = true;

        // visited[1] = true;
        for(int i : A[v]) {
            if(!visited[i]) DFS(i);
        }
    }

    public static void init() {
        for(int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }
    }
}
