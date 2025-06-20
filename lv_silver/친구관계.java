import java.util.*;
import java.io.*;

public class 친구관계 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean cleared;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }

        for(int i = 0; i < N; i++) {
            DFS(i, 1);
            if(cleared) break;
        }

        System.out.println(cleared? 1 : 0);
    }
    // A -> B, B -> C, C -> D, D -> E . 즉, !visited 상태에서 깊이 5까지 방문
    public static void DFS(int v, int depth) {
        if(depth == 5 || cleared) {
            cleared = true;
            return;
        }
        visited[v] = true;

        for(int i : A[v]) {
            if (!visited[i]) DFS(i, depth + 1);
        }

        visited[v] = false; // depth 5 도달 못한 재귀들 false
    }
}