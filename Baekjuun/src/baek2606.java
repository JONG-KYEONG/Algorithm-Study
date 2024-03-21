import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean check [][] = new boolean[n+1][n+1];
        boolean visited [] = new boolean[n+1];
        int cnt = -1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = true;
        }
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int idx = q.poll();
            for(int i = 1; i <= n; i++){
                if(!visited[i] && check[idx][i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
