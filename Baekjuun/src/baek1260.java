import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek1260 {
    static int n, m, k;
    static boolean arr[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean [n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = true;
        }

        visited[k] = true;
        dfs(k);
        sb.append("\n");
        bfs(k);
        System.out.println(sb);


    }

    public static void dfs(int k){
        sb.append(k + " ");
        for(int i = 1; i < n+1; i++){
            if(arr[k][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int k){
        boolean[] visit = new boolean[n+1];
        visit[k] = true;
        Queue <Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp + " ");
            for(int i = 1; i < n+1; i++){
                if(arr[tmp][i] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
