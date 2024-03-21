import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek14503 {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int map[][];
    static int startX, startY, startDir, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        startDir = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(clean());

    }

    public static int clean(){
        Queue<Vacuum> q = new LinkedList<>();
        q.add(new Vacuum(startX, startY, startDir));
        int cnt = 0;
        while (!q.isEmpty()){
            Vacuum vacuum = q.poll();
            int x = vacuum.x;
            int y = vacuum.y;
            int dir = vacuum.dir;
            if(map[x][y] == 0){
                map[x][y] = 2;
                cnt++;
            }
            for(int i = 1; i <= 4; i++){
                int ndir = dir-i;
                if(ndir < 0) {
                    ndir = ndir + 4;
                }
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(map[nx][ny] == 0) {
                        q.add(new Vacuum(nx, ny, ndir));
                        break;
                    }
                }

                if(ndir == dir){
                    int nndir = (ndir+2) % 4;
                    nx = x + dx[nndir];
                    ny = y + dy[nndir];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                        if(map[nx][ny] != 1) {
                            q.add(new Vacuum(nx, ny, ndir));
                            break;
                        }
                        else
                            return cnt;
                    }
                    break;
                }
            }
        }
        return cnt;
    }



    static class Vacuum{
        int x;
        int y;
        int dir;

        Vacuum(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
