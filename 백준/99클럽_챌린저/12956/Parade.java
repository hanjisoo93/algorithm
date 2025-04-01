import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Parade {

    static final int INF = 1_000_000_000;
    static int n, m;
    static int[][] originalDist;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalDist = new int[n][n];

        // 거리 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(originalDist[i], INF);
            originalDist[i][i] = 0;
        }

        // 도로 입력
        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            // 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
            originalDist[from][to] = Math.min(originalDist[from][to], time);
            originalDist[to][from] = Math.min(originalDist[to][from], time);
            edges.add(new Edge(from, to, time));
        }

        // 원본 그래프에 대한 최단 거리 계산
        int[][] base = floyd(copy(originalDist));

        // 각 도로를 막고 있는 퍼레이드 계산
        StringBuilder sb = new StringBuilder();
        for(Edge e : edges) {
            int[][] removed = copy(originalDist);
            removed[e.from][e.to] = INF;
            removed[e.to][e.from] = INF;

            int[][] after = floyd(removed);
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (base[i][j] != after[i][j]) {
                        count++;
                    }
                }
            }

            sb.append(count).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static int[][] floyd(int[][] dist) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }

    static int[][] copy(int[][] arr) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i].clone();
        }
        return res;
    }

    static class Edge {
        int from, to, time;

        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}
