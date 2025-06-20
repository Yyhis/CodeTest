import java.util.*;
import java.io.*;

public class DFS_BFS {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];

        for(int i =0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for(int i = 1; i <=N; i++) Collections.sort(A[i]);
        visited = new boolean[N + 1];
        DFS(start);

        System.out.println();

        bw.append("\n");
        visited = new boolean[N + 1];
        BFS(start);

        // bw.flush();

    }

    public static void DFS(int v) {
        if(visited[v]) return;
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : A[v]) {
            if (!visited[i]) DFS(i);
        }
        
    }

    public static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();

        que.add(v);
        visited[v] = true;

        while(!que.isEmpty()) {
            int q = que.poll();
            System.out.print(q + " ");
            for(int i : A[q]) {
                if (!visited[i]) { 
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
