package coding_test.greedy;

import java.io.*;
import java.util.*;

public class 큰_수의_법칙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];

        for (int i = 0; i < n; i ++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        int first = number[n-1];
        int second = number[n-2];

        int a = m / (k + 1); // 반복
        int b = m % (k + 1); // 큰 수 더하기
        int result = 0;

        result += a * (first * k + second) + b * first;

        System.out.println("result : " + result);
    }
}
