package hust.soict.dsai.huststack;

//JAVA 
import java.util.*; 

@SuppressWarnings({"unchecked", "deprecation"})
public class maze { 
  static int[] dx = {-1, 1, 0, 0}; // trái, phải
  static int[] dy = {0, 0, -1, 1}; // lên, xuống

  public static int bfs(int n, int m, int r, int c, int[][] a) {
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{r, c, 0}); // tọa độ của ô và số bước đi

      boolean[][] visit = new boolean[n][m];
      visit[r][c] = true;

      while (!queue.isEmpty()) {
          int[] current = queue.poll();
          int x = current[0];
          int y = current[1];
          int steps = current[2];

          // Kiểm tra nếu ô hiện tại nằm ở biên và không phải là tường
          if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
              return steps;
          }

          // Duyệt qua 4 hướng
          for (int i = 0; i < 4; i++) {
              int nx = x + dx[i];
              int ny = y + dy[i];

              if (nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] == 0 && !visit[nx][ny]) {
                  visit[nx][ny] = true;
                  queue.add(new int[]{nx, ny, steps + 1});
              }
          }
      }
      return -2;
  }
  public static void main(String[] args) { 
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int r = sc.nextInt();
      int c = sc.nextInt();

      int[][] a = new int[n][m];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              a[i][j] = sc.nextInt();
          }
      }

      r--; c--; // chuyển chỉ số về 0-based

      if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
          System.out.println(-1);
      } else {
          int res = bfs(n, m, r, c, a);
          System.out.println(res + 1);
      }
  }
}
