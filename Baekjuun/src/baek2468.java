import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2468 {
    static int map[][];
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    static int result = 0;
    static int n;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for(int i = min - 1; i <= max; i++){
            result = Math.max(result,bfs2468(i));
        }
        System.out.println(result);

    }

    public static int bfs2468(int s) {
        int tmparr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= s)
                    tmparr[i][j] = 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmparr[i][j] == 0) {
                    cnt++;
                    Queue<Coo> q = new LinkedList<>();
                    q.add(new Coo(i,j));
                    while(!q.isEmpty()){
                        Coo coo = q.poll();
                        for(int c = 0 ; c < 4; c++){
                            int nx = coo.x + dx[c];
                            int ny = coo.y + dy[c];
                            if(nx >= 0 && ny >= 0 && nx < n && ny <n){
                                if(tmparr[nx][ny]==0){
                                    tmparr[nx][ny] = 2;
                                    q.add(new Coo(nx,ny));
                                }
                            }
                        }
                    }

                }
            }
        }
        return cnt;
    }

    static class Coo{
        int x;
        int y;
        Coo(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
