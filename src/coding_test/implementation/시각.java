package coding_test.implementation;

import java.io.*;
import java.util.*;

public class 시각 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int h = 0; h < n + 1; h++) {
            for(int m = 0; m < 60; m ++){
                for(int s = 0; s < 60; s ++){
                    String time = String.valueOf(h) + String.valueOf(m) + String.valueOf(s);
                    if(time.contains(Integer.toString(n))) {
                        result ++;
                    }
                }
            }
        }

        System.out.println("result : " + result);
    }
}
