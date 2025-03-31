import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> gragh = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i ++) {
            gragh.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;   //가중치 처리

            gragh.get(a).add(new Node(b,d));
            gragh.get(b).add(new Node(a,d));
        }

        int[] fox = foxDijkstra(1, n);
        int[][] wolf = wolfDijkstra(1, n);

        int count = 0;
        for(int i = 2; i <= n; i++) {
            int wolfMin = Math.min(wolf[i][0], wolf[i][1]);
            if(fox[i] < wolfMin) count++;
        }

        System.out.println(count);
    }

    public static int[] foxDijkstra(int start, int n) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 가장 짧은 거리인 노드 추출
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.index;
            int curDist = now.distance;

            if(dist[cur] < curDist) continue;   // 이미 더 짧은 경로로 도달한 적 있다면 지금 꺼낸건 무시하자

            for(Node next : gragh.get(cur)) {
                int cost = curDist + next.distance;

                if(cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }

        return dist;
    }

    public static int[][] wolfDijkstra(int start, int n) {
        int[][] wolfDist = new int[n + 1][2];   // [0] 빠르게, [1] 느리게

        for(int i = 0; i <= n; i++) {
            Arrays.fill(wolfDist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));    // 시작 상태는 빠르게 이동할 차례
        wolfDist[start][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.index;
            int curDist = now.distance;
            int state = now.state;

            if(wolfDist[cur][state] < curDist) continue;

            for(Node next : gragh.get(cur)) {
                int nextState = 1 - state;
                int moveCost = (state == 0) ? next.distance / 2 : next.distance * 2;
                int totalCost = curDist + moveCost;

                if(totalCost < wolfDist[next.index][nextState]) {
                    wolfDist[next.index][nextState] = totalCost;
                    pq.offer(new Node(next.index, totalCost, nextState));
                }
            }
        }

        return wolfDist;
    }
}

// 우선순위 큐에서 쓸 노드 정의
class Node implements Comparable<Node> {
    int index, distance, state;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public Node(int index, int distance, int state) {
        this.index = index;
        this.distance = distance;
        this.state = state;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}
