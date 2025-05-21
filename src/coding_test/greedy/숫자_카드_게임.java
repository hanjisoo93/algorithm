package coding_test.greedy;

import java.io.*;
import java.util.*;

public class 숫자_카드_게임 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int nMin;

        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            nMin = 10000;

            for(int j = 0; j < m; j ++) {
                nMin = Math.min(nMin, Integer.parseInt(st.nextToken()));
            }

            max = Math.max(max, nMin);
        }

        int result = max;
        System.out.println("result : " + result);
    }
}
