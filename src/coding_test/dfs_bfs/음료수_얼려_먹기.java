package coding_test.dfs_bfs;

import java.io.*;

public class 음료수_얼려_먹기 {

    public static int[][] arr;
    public static int n; // 행
    public static int m; // 렬

    public static boolean dfs(int i, int j) {

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (arr[i][j] == 0) {
            arr[i][j] = 1;

            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);

            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer=0;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] text = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(text[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)) {answer++;}
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
