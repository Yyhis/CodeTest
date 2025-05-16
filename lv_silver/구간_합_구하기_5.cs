using System.Text;
using System.IO;

public class Program {
    public static void Main() {
        StreamReader sr = new StreamReader(Console.OpenStandardInput());
        string[] s = sr.ReadLine().Split();

        int N = int.Parse(s[0]);
        int M = int.Parse(s[1]);

        int[,] a = new int[N + 1, N + 1];
        int[,] d = new int[N + 1, N + 1];

        StringBuilder bf = new StringBuilder();

        for (int i = 1; i <=N; i++) {
            s = sr.ReadLine().Split();

            for(int j = 1; j <=N; j++) {
                a[i, j] = int.Parse(s[j - 1]);
                d[i, j] = d[i, j-1] + d[i-1, j] - d[i-1, j-1] + a[i, j];
            }
        }

        for (int i = 0; i < M; i++) {
            s = sr.ReadLine().Split();

            int x1 = int.Parse(s[0]);
            int y1 = int.Parse(s[1]);
            int x2 = int.Parse(s[2]);
            int y2 = int.Parse(s[3]);

            int result = d[x2, y2] - d[x2, y1-1] - d[x1-1, y2] + d[x1-1, y1-1];

            bf.AppendLine(result.ToString());
            // Console.Write 루프에서 반복 호출 시 I/O 병목이 발생 => 시간초과
            // Console.Write(result.ToString());
        }
        Console.Write(bf.ToString());
    }
}