package coding_test.implementation;
import java.util.*;
import java.io.*;

public class 상하좌우 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] moves = br.readLine().split(" ");

        String[] directions = {"L", "R", "U", "D"};
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0 ,0};

        int x = 1;
        int y = 1;

        for(String move : moves) {
            for(int i = 0; i < directions.length; i++) {
                if(move.equals(directions[i])) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                        x = nx;
                        y = ny;
                    }
                    break;
                }
            }
        }

        String result1 = Integer.toString(x) + " " + Integer.toString(y);
        System.out.println("result : " + result1);

//        int n1 = 1;
//        int n2 = 1;
//
//        for(int i = 0; i < moves.length; i ++) {
//            moves[i] = st.nextToken();
//
//            switch(moves[i]) {
//                case "L" :
//                    if(n2 > 1) {
//                        n2 --;
//                    }
//                    break;
//                case "R" :
//                    if(n2 < n) {
//                        n2 ++;
//                    }
//                    break;
//                case "U" :
//                    if(n1 > 1) {
//                        n1 --;
//                    }
//                    break;
//                case "D":
//                    if(n1 < n) {
//                        n1 ++;
//                    }
//                    break;
//            }
//        }
//
//        String result = Integer.toString(n1) + " " + Integer.toString(n2);
//        System.out.println("result : " + result);
    }
}
