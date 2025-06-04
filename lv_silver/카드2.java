import java.util.*;

public class 카드2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // FIFO
        Queue<Integer> queue = new LinkedList<>();

        // 초기화
        for(int i = 0; i <N; i++) {
            queue.add(i+1);
        }

        int result = 0, rotation;

        while(!queue.isEmpty()) {
            result = queue.remove(); // 첫번째 값 제거 or 마지막 값 반환
            if (queue.isEmpty()) break;
            
            rotation = queue.remove();
            queue.add(rotation);
        }

        System.out.println(result);

    }
}
