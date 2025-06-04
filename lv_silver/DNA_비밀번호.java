import java.io.*;
import java.util.*;

public class DNA_비밀번호 {
    static int[] check;

    public static void main(String args[]) throws IOException {
        long startTime = System.nanoTime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] pw = new char[S];    // CCTGGATTG
        pw = br.readLine().toCharArray();

        int[] dnaNum = new int[4];
        int[] currNum = new int[4];
        check = new int[4]; // 2 0 1 1
        int count = 0;

        for(int i =0; i<S; i++) {
            if(pw[i] == 'A') dnaNum[0]++;
			if(pw[i]=='C') dnaNum[1]++;
			if(pw[i]=='G') dnaNum[2]++;
			if(pw[i]=='T') dnaNum[3]++;
        }

        // 문자 전체 확인해서 조합되는지 확인 -> 최악의 경우우
        if(!checkNum(dnaNum)) {
			System.out.print(count);
			return;
		}

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
 
        // 맨 처음 문자 조합 저장
        for (int i = 0; i < P; i++) {
            if(pw[i] == 'A') currNum[0]++;
			if(pw[i]=='C') currNum[1]++;
			if(pw[i]=='G') currNum[2]++;
			if(pw[i]=='T') currNum[3]++;
        }
        if(checkNum(currNum)) count++;

        for (int j = P; j < S; j++) { // 뒷 인덱스
            int i = j - P; // 앞 인덱스

            // 지나간 인덱스 값은 빼주고
            if(pw[i] == 'A') currNum[0]--;
			if(pw[i]=='C') currNum[1]--;
			if(pw[i]=='G') currNum[2]--;
			if(pw[i]=='T') currNum[3]--;
            
            // 들어오는 인덱스 값은 더하기기
            if(pw[j] == 'A') currNum[0]++;
			if(pw[j]=='C') currNum[1]++;
			if(pw[j]=='G') currNum[2]++;
			if(pw[j]=='T') currNum[3]++;

            if(checkNum(currNum)) count++;
        }

        System.out.println(count);

        long endTime = System.nanoTime();

        double executionTime = (endTime-startTime) / 1_000_000.0;
        System.out.printf("\n실행 시간: %.3f ms\n", executionTime);
    }

    public static boolean checkNum(int[] num) {
        for(int i=0;i<4;i++) {
			if(num[i] < check[i])
				return false;
		}
		return true;
    }
}
