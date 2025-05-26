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
                    if(String.valueOf(h).contains(Integer.toString(n)) ||
                        String.valueOf(m).contains(Integer.toString(n))||
                        String.valueOf(s).contains(Integer.toString(n))) {
                       result ++;
                    }
                }
            }
        }

        System.out.println("result : " + result);
    }
}
