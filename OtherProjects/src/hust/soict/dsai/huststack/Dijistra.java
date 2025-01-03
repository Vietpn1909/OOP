package hust.soict.dsai.huststack;

import java.util.*;

public class Dijistra {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int dijkstra(int n, List<List<Edge>> graph, int start, int target) {
        int[] dist = new int[n + 1]; // Khoảng cách ngắn nhất từ s đến từng đỉnh
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) continue; // Nếu khoảng cách không tối ưu, bỏ qua

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return dist[target] == Integer.MAX_VALUE ? -1 : dist[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Số đỉnh
        int m = sc.nextInt(); // Số cạnh

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v, w));
        }

        int s = sc.nextInt(); // Đỉnh bắt đầu
        int t = sc.nextInt(); // Đỉnh kết thúc

        int result = dijkstra(n, graph, s, t);
        System.out.println(result);
    }
}
