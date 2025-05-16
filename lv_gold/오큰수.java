package lv_gold;
import java.util.*;
import java.io.*;

// 17298
// 에러1: 메모리 초과
// 원인1: O(n^2)이라 메모리 초과 -> 정답지 분석 결과 while(조건)이라 O(2n)이라 조건에 break를 넣었지만 실패..
public class 오큰수 {
    public static void main(String args[]) throws IOException{
        // Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // int[] a = new int[n];

        // for (int i=0; i<n; i++) {
        //     a[i] = sc.nextInt(); 
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuffer bf = new StringBuffer();

        int[] nge = new int[n];

        for (int i = 0; i <n; i++) {
            if(stack.isEmpty()) stack.push(i);  // 1 -> 5

            // stack 있을때 + 처음 값이 현재 반복 중인 값보다 낮을 때 -> 조건 통과 오큰수 중 하나일 가능성
            // 오큰수를 저장
            while(!stack.isEmpty() && a[stack.peek()]< a[i]) { 
                stack.push(i);
            }

            
            nge[stack.peek()] = a[stack.pop()]; 

            // 위에서 오큰수를 pop하면서 값을 얻으니까. 마지막에 맨처음 index만 pop 해주면 다 비워짐.
            stack.pop();
            

            if(nge[1] == 0) bf.append(-1+" ");

            bf.append(nge[1]+" ");
        }
        System.out.println(bf.toString());
    }
    
    /// 도전 1
    // public static void main(String args[]) throws IOException{
    //     // Scanner sc = new Scanner(System.in);

    //     // int n = sc.nextInt();
    //     // int[] a = new int[n];

    //     // for (int i=0; i<n; i++) {
    //     //     a[i] = sc.nextInt(); 
    //     // }

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int[] a = new int[n];
    //     for(int i=0; i<n; i++) {
    //         a[i] = Integer.parseInt(st.nextToken());
    //     }

    //     // Stack<Integer> stack = new Stack<>();
    //     StringBuffer bf = new StringBuffer();
    
    //     for (int i = 0; i <n; i++) {
         
    //         /// 도전 2
    //         int nge = -1;
    //         for (int j = i + 1; j<n; j++) {
    //             if(nge == -1) { // always true
    //                 if (a[i] < a[j]) {
    //                     nge = j;
    //                     break;
    //                 } 
    //             }
    //         }
    //         if (nge == -1) bf.append(nge +" ");
    //         else bf.append(a[nge] + " ");
    //     }
    //     System.out.println(bf.toString());
    // }
}