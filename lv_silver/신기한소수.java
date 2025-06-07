import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 신기한소수 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

        
    }

    // N = 1인 경우: 2, 3, 5, 7 (1자리 소수)
    // N = 2인 경우: 21, 23, 29, 31, 37, 53, 59, 71, 73, 79 (2자리 소수)
    // N = 3인 경우: 211, 213, 217, 219, 231, 233, 239, 271, 273, 277, 279, 293, 299, 311, 313, 317, 319, 331, 337, 339, 353, 359, 373, 379, 397, 517, 519, 531, 533, 539, 593, 599, 713, 719, 733, 739, 797 (3자리 소수


    // 맨 앞 자리
    // 2 3 5 7

    // 2번째 이상 자리 -> 나누기 안될 가능성 있는 홀수!!
    // 1 3 5 7 9

    public static void DFS(int number, int jarisu) {
        // 4자리수이면 
        if(jarisu == N) {
            if(isPrime(number)) System.out.println(number); // 해당 소수 출력
        }

        // 1 3 5 7 9
        for(int i = 1; i <=9; i += 2) {
            if(isPrime(number)) DFS((number * 10) + i, jarisu + 1);
        }
    }

    // 방법1. 2 ~ N-1 의 수로 나눠보는 법 ( 나눠지면 소수가 아니다. ) -> 시간 복잡도는 O(N)
    // 방법2. 2 ~ N/2까지만 확인하는 방법 (Why ? 자기자신을 제외하고 절반을 초과하는 숫자에서 나눴을때 나머지가 0이되는 숫자는 나올수가 없다.) -> 시간 복잡도는 O(N)
    // 방법3. 2 ~ √N 까지 확인하는 방법 (Why ? 약수의 중심을 활용하는 방법이다.) -> 시간 복잡도는 O(√N)
    public static boolean isPrime(int number) {
        // 루트N 방식
        // i * i <= N  ----> i <= √N 과 동일
        for(int i = 2; i * i <= number; i++) {
            if(number % i ==0) {
                return false; 
            }
        }
        return true;
    }
}
