using System.Text;
using System.IO;

public class Program {
    public static void Main() {
        StreamReader sr = new StreamReader(Console.OpenStandardInput());
        string[] s;
        int N = int.Parse(sr.ReadLine());
        int M = int.Parse(sr.ReadLine());

        int[] a = new int[N];
        s = sr.ReadLine().Split();

        for (int i = 0; i < N; i++) {
            a[i] = int.Parse(s[i]);
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if(i<= j) continue;
                if(a[i]+a[j]==M) count++;
            }
        }
        Console.Write(count.ToString());
    }
}