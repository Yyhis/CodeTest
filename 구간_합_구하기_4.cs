using System.Text;
using System.IO;

public class Program {
    public static void Main() {
        StreamReader sr = new StreamReader(Console.OpenStandardInput());
        string[] s = sr.ReadLine().Split();
        int N = int.Parse(s[0]);
        int M = int.Parse(s[1]);

        int[] a = new int[N];
        int[] S = new int[N+1];

        int start, end;
        StringBuilder bf = new StringBuilder();

        s = sr.ReadLine().Split();

        for(int i = 0; i < N; i++) {
            a[i] = int.Parse(s[i]);
            S[i + 1] = S[i] + a[i];
        }

        for(int j = 0; j < M; j++) {
            s = sr.ReadLine().Split();
            start = int.Parse(s[0]);
            end = int.Parse(s[1]);

            bf.AppendLine((S[end] - S[start - 1]).ToString());
        }

        Console.Write(bf.ToString());
    }
}